/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TiendaAllanAzofeifa.demo.impl;

import TiendaAllanAzofeifa.demo.domain.Roles;
import TiendaAllanAzofeifa.demo.domain.Usuarios;
import TiendaAllanAzofeifa.demo.service.UsuarioDetailsService;
import TiendaAllanAzofeifa.demo.dao.UsuariosDao;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UsuarioDetailsServiceImpl implements UsuarioDetailsService, UserDetailsService {

    @Autowired
    private UsuariosDao usuarioDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
       
        Usuarios usuario = usuarioDao.findByNombre(nombre);
        
        if (usuario == null) {
            throw new UsernameNotFoundException(nombre);
        }

        var roles = new ArrayList<GrantedAuthority>();
        for (Roles rol : usuario.getRoles()) {
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
        return new User(usuario.getNombre(), usuario.getPassword(), roles);
    }
}
