package com.toan.identity_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.toan.identity_service.dto.request.PermissionRequest;
import com.toan.identity_service.dto.response.PermissionResponse;
import com.toan.identity_service.entity.Permission;
import com.toan.identity_service.mapper.PermissionMapper;
import com.toan.identity_service.repository.PermissionRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermissionService {
    PermissionRepository permissionRepository;
    PermissionMapper permissionMapper;

    public PermissionResponse create(PermissionRequest request) {
        Permission permission = permissionMapper.toPermission(request);
        return permissionMapper.toPermissionResponse(permissionRepository.save(permission));
    }

    public List<PermissionResponse> getAll() {
        var permission = permissionRepository.findAll();
        return permission.stream().map(permissionMapper::toPermissionResponse).toList();
    }

    public void deleteById(String permission) {
        permissionRepository.deleteById(permission);
    }
}
