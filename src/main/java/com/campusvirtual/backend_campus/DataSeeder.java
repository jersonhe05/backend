package com.campusvirtual.backend_campus;

import com.campusvirtual.backend_campus.entity.*;
import com.campusvirtual.backend_campus.entity.util.Rol;
import com.campusvirtual.backend_campus.repository.AlumnoRepository;
import com.campusvirtual.backend_campus.repository.ProfesorRepository;
import com.campusvirtual.backend_campus.repository.UsuarioRepository;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Locale;

@Configuration
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {
    private final AlumnoRepository alumnoRepository;
    private final ProfesorRepository profesorRepository;
    private final UsuarioRepository usuarioRepository;
    private final Faker faker = new Faker(new Locale("es"));
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (usuarioRepository.count() > 0) {
            System.out.println("🟡 Ya existen usuarios, se omite la carga de prueba.");
            return;
        }

        crearProfesores(25);
        crearAlumnos(25);
        crearAdministradores(5);
    }

    private void crearProfesores(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            Profesor profesor = (Profesor) Profesor.builder()
                    .primerNombre(faker.name().firstName())
                    .segundoNombre(faker.name().firstName())
                    .primerApellido(faker.name().lastName())
                    .segundoApellido(faker.name().lastName())
                    .email(faker.internet().emailAddress())
                    .contrasenaHash(passwordEncoder.encode("123456")) // Usa un encoder real en producción
                    .rol(Rol.PROFESOR)
                    .build();

            profesorRepository.save(profesor);
        }
        System.out.println("✅ Profesores creados.");
    }

    private void crearAlumnos(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            Alumno alumno = (Alumno) Alumno.builder()
                    .primerNombre(faker.name().firstName())
                    .segundoNombre(faker.name().firstName())
                    .primerApellido(faker.name().lastName())
                    .segundoApellido(faker.name().lastName())
                    .email(faker.internet().emailAddress())
                    .contrasenaHash(passwordEncoder.encode("123456")) // Usa un encoder real en producción
                    .rol(Rol.ESTUDIANTE)
                    .build();

            alumnoRepository.save(alumno);
        }
        System.out.println("✅ Alumnos creados.");
    }

    private void crearAdministradores(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            Usuario admin = Usuario.builder()
                    .primerNombre(faker.name().firstName())
                    .segundoNombre(faker.name().firstName())
                    .primerApellido(faker.name().lastName())
                    .segundoApellido(faker.name().lastName())
                    .email("admin" + i + "@admin.com")
                    .contrasenaHash(passwordEncoder.encode("admin123456")) // Usa un encoder real
                    .rol(Rol.ADMINISTRADOR)
                    .build();

            usuarioRepository.save(admin);
        }
        System.out.println("✅ Administradores creados.");
    }
}

