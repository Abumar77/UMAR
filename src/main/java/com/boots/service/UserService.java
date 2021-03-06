package com.boots.service;

import com.boots.entity.*;
import com.boots.repository.*;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @PersistenceContext
    private EntityManager em;


    private final UserRepository userRepository;


    private final  RoleRepository roleRepository;


    private final  BCryptPasswordEncoder bCryptPasswordEncoder;


    private final CourseRepository courseRepository;


    private final ContentRepository contentRepository;


    private final TextRepository textRepository;


    private final VideoRepository videoRepository;


    private final WeekRepository weekRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder, CourseRepository courseRepository, ContentRepository contentRepository, TextRepository textRepository, VideoRepository videoRepository, WeekRepository weekRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.courseRepository = courseRepository;
        this.contentRepository = contentRepository;
        this.textRepository = textRepository;
        this.videoRepository = videoRepository;
        this.weekRepository = weekRepository;
    }


    // USER
    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new Exception("Student not found - " + username));

        return user;
    }

    public User findUserById(Long userId) {
        Optional<User> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new User());
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }




    public boolean saveUser(User user) {
        Optional<User> userFromDB = userRepository.findByUsername(user.getUsername());

        if (userFromDB != null) {
            return false;
        }

        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    public boolean deleteUser(Long userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    public List<User> usergtList(Long idMin) {
        return em.createQuery("SELECT u FROM User u WHERE u.id > :paramId", User.class)
                .setParameter("paramId", idMin).getResultList();
    }





    // Course service
    public List<Course> allCourses() {
        return courseRepository.findAll();
    }


    public List<Course> coursegt(int idMin) {
        return em.createQuery("SELECT c FROM Course c WHERE c.cid = :paramId", Course.class)
                .setParameter("paramId", idMin).getResultList();
    }

    public List<Week> allweek() {
        return weekRepository.findAll();
    }

    public List<VideoMaterials> allvideo() {
        return videoRepository.findAll();
    }

    public List<TextMaterials> alltext() {
        return textRepository.findAll();
    }


    public List<Week> weekget(int idMin) {
        return em.createQuery("SELECT c FROM Week c WHERE c.wid = :paramId", Week.class)
                .setParameter("paramId", idMin).getResultList();
    }

    public List<VideoMaterials> videoget(int idMin) {
        return em.createQuery("SELECT c FROM VideoMaterials c WHERE c.vid = :paramId", VideoMaterials.class)
                .setParameter("paramId", idMin).getResultList();
    }

    public List<TextMaterials> txtget(int idMin) {
        return em.createQuery("SELECT c FROM TextMaterials c WHERE c.tid = :paramId", TextMaterials.class)
                .setParameter("paramId", idMin).getResultList();
    }

}