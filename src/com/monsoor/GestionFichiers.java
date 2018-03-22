package com.monsoor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GestionFichiers {

	public static void main(String[] args) {
		GererFichier();
		GererBinaire();
}

	/**
	 * 
	 */
	private static void GererBinaire() {
		//Les flux binaires
				
				FileInputStream fi = null;
				try {
					fi= new FileInputStream("C:\\Users\\ACI\\Documents\\test.bin.txt");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int n = 0;
				//byte[] buf = new byte[8];
				do {
					try {
						//On lit des bytes et c'est en code ASCII
						n=fi.read();
						System.out.println();
		
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//Some stuff
				} 
				while(n!=-1);
				try {
					fi.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	/**
	 * 
	 */
	private static void GererFichier() {
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
