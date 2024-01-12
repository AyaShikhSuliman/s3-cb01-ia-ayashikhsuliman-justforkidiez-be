package com.example.justyourkidiez.business.impl.Parent;

import com.example.justyourkidiez.business.UseCases.Parent.CreateParentUseCase;
import com.example.justyourkidiez.business.exception.NameAlreadyExistsException;
import com.example.justyourkidiez.domain.Parent.CreateParentRequest;
import com.example.justyourkidiez.domain.Parent.CreateParentResponse;
import com.example.justyourkidiez.persistence.ParentRepository;
import com.example.justyourkidiez.persistence.UserRepository;
import com.example.justyourkidiez.persistence.entity.*;
import com.example.justyourkidiez.persistence.entity.User.RoleEnum;
import com.example.justyourkidiez.persistence.entity.User.UserEntity;
import com.example.justyourkidiez.persistence.entity.User.UserRoleEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CreateParentUseCaseImpl implements CreateParentUseCase {
    private static final String USERNAME_SUFFIX = "@justyourkidiez.nl";

    private final ParentRepository parentRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public CreateParentResponse createParent(CreateParentRequest request) {
        if (parentRepository.existsByName(request.getName())) {
            throw new NameAlreadyExistsException();
        }

        ParentEntity savedParent = saveNewParent(request);

        saveNewUser(savedParent, request.getPassword());

        return CreateParentResponse.builder()
                .parentId(savedParent.getId())
                .build();
    }

    private void saveNewUser(ParentEntity parent, String password) {
        String encodedPassword = passwordEncoder.encode(password);

        UserEntity newUser = UserEntity.builder()
                .username(parent.getName() + USERNAME_SUFFIX)
                .password(encodedPassword)
                .parent(parent)
                .build();
        System.out.println(newUser);
        newUser.setUserRoles(Set.of(
                UserRoleEntity.builder()
                        .user(newUser)
                        .role(RoleEnum.PARENT)
                        .build()));
        userRepository.save(newUser);
    }

    private ParentEntity saveNewParent(CreateParentRequest request) {
        ParentEntity newParent = ParentEntity.builder()
                .name(request.getName())
                .last_name(request.getLast_name())
                .age(request.getAge())
                .phone_number(request.getPhone_number())
                .email_address(request.getEmail_address())
                .country(request.getCountry())
                .build();
        return parentRepository.save(newParent);
    }
}
