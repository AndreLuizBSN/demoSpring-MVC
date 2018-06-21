package com.mballem.curso.boot.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mballem.curso.boot.dao.UsuarioDao;
import com.mballem.curso.boot.domain.Usuario;

@Service @Transactional(readOnly=false)
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioDao dao;

	@Override
	public void salvar(Usuario usuario) {
		dao.save(usuario);
	}

	@Override
	public void editar(Usuario usuario) {
		dao.update(usuario);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	public Usuario buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Usuario> buscarTodos() {
		return dao.findAll();
	}

	@Override
	public Usuario buscarPorLoginESenha(String login, String senha) {
		return dao.findByLoginESenha(login, md5(senha));
	}

	public static String md5(String input) {
        String md5 = null;
        if(null == input) return null;
        try {
        //Create MessageDigest object for MD5
        MessageDigest digest = MessageDigest.getInstance("MD5");
        //Update input string in message digest
        digest.update(input.getBytes(), 0, input.length());
        //Converts message digest value in base 16 (hex) 
        md5 = new BigInteger(1, digest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5;
    }
	
}
