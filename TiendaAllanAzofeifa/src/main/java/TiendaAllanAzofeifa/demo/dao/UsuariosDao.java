/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package TiendaAllanAzofeifa.demo.dao;

import TiendaAllanAzofeifa.demo.domain.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosDao extends JpaRepository<Usuarios, Long> {
    Usuarios findByNombre(String nombre);
    
    Usuarios findByNombreAndPassword(String nombre, String password);

    Usuarios findByNombreOrEmail(String nombre, String email);

    boolean existsByNombreOrEmail(String nombre, String email);
}