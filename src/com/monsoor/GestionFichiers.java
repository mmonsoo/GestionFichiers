package com.monsoor;

import java.io.File;

public class GestionFichiers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String root=System.getProperty("user.dir");
		System.out.println(root);
		//On créer le fichier. Le File.separator gère automatiquement les différents type de séparateur suivant si c'est Unix ou Windows.
		File f= new File(root+File.separator+"MonSousRepertoire");
		//Si le dossier n'existe pas, on le créer, sinon on ne le créer pas car il existe déjà.
		if(!f.exists()) {
			f.mkdir();
		}

	}

}
