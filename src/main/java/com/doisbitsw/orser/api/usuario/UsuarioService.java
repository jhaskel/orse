package com.doisbitsw.orser.api.usuario;


import com.doisbitsw.orser.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository rep;
    public List<UsuarioDTO> getUsuarios() {
        List<UsuarioDTO> list = rep.findAll().stream().map(UsuarioDTO::create).collect(Collectors.toList());
        return list;
    }

    public UsuarioDTO getUsuarioById(Long id) {
        Optional<Usuario> usuario = rep.findById(id);
        return usuario.map(UsuarioDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }



    public double QuantNoticia(Long usuario){
        return rep.QuantNoticia(usuario);
    }


    public Long QuantEmail(String email){
        return rep.QuantEmail(email);
    }



    public List<UsuarioDTO> getEntidade(Long entidade) {
        return rep.findEntidade(entidade).stream().map(UsuarioDTO::create).collect(Collectors.toList());
    }


    public List<UsuarioDTO> getId(Long id) {
        return rep.findId(id).stream().map(UsuarioDTO::create).collect(Collectors.toList());
    }


    public UsuarioDTO insert(Usuario usuario) {
        Assert.isNull(usuario.getId(),"Não foi possível inserir o registro");
        return UsuarioDTO.create(rep.save(usuario));
    }

    public UsuarioDTO update(Usuario usuario, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o usuario no banco de dados
        Optional<Usuario> optional = rep.findById(id);
        if(optional.isPresent()) {
            Usuario db = optional.get();
            db.setNome(usuario.getNome());
            db.setSenha(usuario.getSenha());
           db.setEmail(usuario.getEmail());
           db.setNivel(usuario.getNivel());
           db.setCpf(usuario.getCpf());
           db.setCelular(usuario.getCelular());
           db.setIsativo(usuario.getIsativo());
           db.setLocalidade(usuario.getLocalidade());
           db.setSetor(usuario.getSetor());
           db.setReceberemail(usuario.getReceberemail());
           db.setLogin(usuario.getLogin());


            System.out.println("Usuario id " + db.getId());

            // Atualiza o usuario
            rep.save(db);
            return UsuarioDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }


    public List<UsuarioDTO> getTesteById(Long id) {
        return rep.findTesteById(id).stream().map(UsuarioDTO::create).collect(Collectors.toList());
    }


    public List<UsuarioDTO> getTesteByEmail(String email) {
        return rep.findTesteByEmail(email).stream().map(UsuarioDTO::create).collect(Collectors.toList());
    }


    public List<UsuarioDTO> getTesteByNivel(String nivel) {
        return rep.findTesteByNivel(nivel).stream().map(UsuarioDTO::create).collect(Collectors.toList());
    }


}
