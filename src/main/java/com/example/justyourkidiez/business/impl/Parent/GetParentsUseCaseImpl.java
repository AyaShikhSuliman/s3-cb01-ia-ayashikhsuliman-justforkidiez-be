package com.example.justyourkidiez.business.impl.Parent;

import com.example.justyourkidiez.business.UseCases.Parent.GetParentsUseCase;
import com.example.justyourkidiez.business.impl.Course.CourseConverter;
import com.example.justyourkidiez.domain.Course.GetCoursesResponse;
import com.example.justyourkidiez.domain.Parent.GetAllParentsRequest;
import com.example.justyourkidiez.domain.Parent.GetAllParentsResponse;
import com.example.justyourkidiez.domain.Parent.Parent;
import com.example.justyourkidiez.persistence.ParentRepository;
import com.example.justyourkidiez.persistence.entity.Course.CourseEntity;
import com.example.justyourkidiez.persistence.entity.ParentEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@AllArgsConstructor
public class GetParentsUseCaseImpl implements GetParentsUseCase {
    private ParentRepository parentRepository;

    @Override
    public GetAllParentsResponse getParents() {
        List<Parent> parents = parentRepository.findAll()
                .stream()
                .map(ParentConverter::convert)
                .toList();

        return GetAllParentsResponse.builder()
                .parents(parents)
                .build();
    }
}
