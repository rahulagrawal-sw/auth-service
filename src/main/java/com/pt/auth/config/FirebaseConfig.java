package com.pt.auth.config;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;

@Configuration
public class FirebaseConfig {
	
	private static final String CONFIG_FILE = "/mi-dashboard-key.json";

	@Primary
	@Bean
	public void firebaseInit() throws IOException {
		
		InputStream credentialsStream = this.getClass().getResourceAsStream(CONFIG_FILE);
		
		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(credentialsStream))
				//.setDatabaseUrl(secProps.getFirebaseProps().getDatabaseUrl())
				.build();
		if (FirebaseApp.getApps().isEmpty()) {
			FirebaseApp.initializeApp(options);
		}
	}

	@Bean
	public Firestore getDatabase() throws IOException {
		InputStream credentialsStream = this.getClass().getResourceAsStream(CONFIG_FILE);
		FirestoreOptions firestoreOptions = FirestoreOptions.newBuilder()
				.setCredentials(GoogleCredentials.fromStream(credentialsStream)).build();
		return firestoreOptions.getService();
	}

	@Bean
	@DependsOn("firebaseInit")
	public FirebaseApp firebaseApp() {
		return FirebaseApp.getInstance();
	}
	
	@Bean
	public FirebaseAuth firebaseAuth(FirebaseApp firebaseApp) {
		return FirebaseAuth.getInstance(firebaseApp);
	}
}
