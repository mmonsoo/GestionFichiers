package com.monsoor;

import java.io.File;

public class GestionFichiers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String root=System.getProperty("user.dir");
		System.out.println(root);
		//On cr�er le fichier. Le File.separator g�re automatiquement les diff�rents type de s�parateur suivant si c'est Unix ou Windows.
		File f= new File(root+File.separator+"MonSousRepertoire");
		//Si le dossier n'existe pas, on le cr�er, sinon on ne le cr�er pas car il existe d�j�.
		if(!f.exists()) {
			f.mkdir();
		}

	}

}
