package com.monsoor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GestionFichiers {

	public static void main(String[] args)    {
		//GererFichier();
		//GererBinaire();
		//WriteBinaire();
		//learnReadFile();
		AnotherMethodReadFile();
		
	}


	/**
	 * 
	 */
	private static void AnotherMethodReadFile() {
		RandomAccessFile aFile = null;
		try {
			aFile = new RandomAccessFile("C:\\Users\\ACI\\Documents\\FichierALire3.txt","r");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileChannel inChannel=aFile.getChannel();
		// Le buffer est un conteneur et il ya une taille 1024
		ByteBuffer buffer=ByteBuffer.allocate(1024);
		try {
			while(inChannel.read(buffer) > 0) {
				//On lit le contenu du buffer
				buffer.flip();
				//On lit chaque lettre du buffer
				for(int i=0;i<buffer.limit();i++) {
					System.out.print((char)buffer.get());
				}
				//On vide le buffer
				buffer.clear();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			inChannel.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			aFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * 
	 */
	private static void learnReadFile() {
		//On déclare et initialise l'objet BufferedRead
		// Ce n'est pas un flux(stream), c'est un buffer!!!!
		BufferedReader br=null;
		//On définit la ligne courante qu'on lit
		String sCurrentLine=null;
		try {
			br=new BufferedReader(new FileReader("C:\\\\Users\\\\ACI\\\\Documents\\\\FichierALire3.txt"));		
			while ((sCurrentLine=br.readLine())!=null)
				System.out.println(sCurrentLine);
					
		}
	catch(IOException e) {
		e.printStackTrace();	
	}
	
	finally {
		try {
			if(br!=null)
				br.close();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
			
	}
	}		


	private static void WriteBinaire() {
		// TODO Auto-generated method stub
		String msg="Mon message à écrire\tLOOOOL";
		OutputStream os = null;
		try {
			// On met false pour écraser le fichier. Si on laisse true, ça écrit à la suite
			os = new FileOutputStream("C:\\Users\\ACI\\Documents\\FichierAEcrit2.txt",false);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			//Il convertir les lettres en bytes
			os.write(msg.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			//ça libère le fichier
			os.flush();
			//On referme le fichier
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
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
				//On crée un tableau de byte pour la lecture
				 //byte[] buf = new byte[8];
				//byte[] buf = new byte[8];
				do {
					try {
						//On lit des bytes et c'est en code ASCII
						n=fi.read();
						// On affiche pas la fin du fichier -1
						if(n!=-1) {
						//On transforme le code ASCII en char
				        System.out.print((char) n);
						}
		
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//Some stuff
				} 
				while(n!=-1); // ça ferme le flux d'entrée
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
