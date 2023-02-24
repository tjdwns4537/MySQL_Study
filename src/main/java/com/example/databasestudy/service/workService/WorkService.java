package com.example.databasestudy.service.workService;

import com.example.databasestudy.repository.WorkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkService {
    private final WorkRepository workRepository;

    public void save() {

    }
}
