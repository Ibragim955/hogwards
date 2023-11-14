package ru.hogwarts.school.service.implemention;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.school.controller.AvatarController;
import ru.hogwarts.school.model.Avatar;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.AvatarRepository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

import static java.nio.file.StandardOpenOption.CREATE_NEW;
@Service
@Transactional
public class AvatarService {
    @Value("${path.to.avatars.folder}")
    private String avatarsDir;
    private  AvatarService avatarService;
    private AvatarRepository avatarRepository;
    private JpaRepository<Student, Long> studentRepository;
    private  AvatarController avatarController;

    public AvatarService(AvatarService avatarService, AvatarController avatarController) {
        this.avatarService = avatarService;
        this.avatarController = avatarController;

    }
    @Autowired  // letting Spring know to autowire this constructor
    public AvatarService(AvatarRepository avatarRepository) {
        this.avatarRepository = avatarRepository;
    }

    public AvatarService(AvatarService avatarService, AvatarRepository avatarRepository, AvatarController avatarController) {
        this.avatarService = avatarService;
        this.avatarRepository = avatarRepository;
        this.avatarController = avatarController;
    }


    public void uploadAvatar(Long studentId, MultipartFile avatarFile) throws IOException {
        Student student = studentRepository.getById(studentId);
        Path filePath = Path.of(avatarsDir, student + "." + getExtensions(Objects.requireNonNull(avatarFile.getOriginalFilename())));
        Files.createDirectories(filePath.getParent());
        Files.deleteIfExists(filePath);
        try (
                InputStream is = avatarFile.getInputStream();
                OutputStream os = Files.newOutputStream(filePath, CREATE_NEW);
                BufferedInputStream bis = new BufferedInputStream(is, 1024);
                BufferedOutputStream bos = new BufferedOutputStream(os, 1024);
        ) {
            bis.transferTo(bos);
        }
        Avatar avatar = findAvatar(studentId);
        avatar.setStudent(student);
        avatar.setFilePath(filePath.toString());
        avatar.setFileSize(avatarFile.getSize());
        avatar.setMediaType(avatarFile.getContentType());
        avatar.setData(avatarFile.getBytes());
        avatarRepository.save(avatar);
    }

    public Avatar findAvatar(Long studentId) {
        return avatarService.findAvatar(studentId);
    }


    private String getExtensions(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }


}

