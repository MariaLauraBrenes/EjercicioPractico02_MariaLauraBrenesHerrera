/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package TiendaAllanAzofeifa.demo.service;

import org.springframework.security.core.userdetails.*;

public interface UsuarioDetailsService {
    
public UserDetails loadUserByUsername (String nombre) throws UsernameNotFoundException;

}
