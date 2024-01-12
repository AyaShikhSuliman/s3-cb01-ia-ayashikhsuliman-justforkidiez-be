package com.example.justyourkidiez.business.impl.Parent;

import com.example.justyourkidiez.business.UseCases.Parent.DeleteParentUseCase;
import com.example.justyourkidiez.persistence.ParentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteParentUseCaseImpl implements DeleteParentUseCase {
    private final ParentRepository parentRepository;

    @Override
    @Transactional
    public void deleteParent(long parentId) {
        this.parentRepository.deleteById(parentId);
    }
}
