package com.projet.type.utilitaires;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

//import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utils {

	private static final Logger LOG = LoggerFactory.getLogger(Utils.class);

	private Utils() {
		super();
	}

	public static String encryptBcrypt(final String password) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(password);
		return encodedPassword;
	}

	public static double convertStringToDouble(String str) {
		double d = 0;
		if (str != null) {

			String string = str.replace(",", ".");
			d = Double.parseDouble(string);

		}
		return d;
	}

	public static double calculBudgetAcMarge(double montant, double marge) {
		return montant * marge;
	}

	 public static String makeRandomPass() {
	 return ""; 
//			 RandomStringUtils.random(8,
//	 "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789?!&$-=_*@:,.;#".toCharArray());
	 }

	public static boolean isSamePass(final String password,
			String encodedPassword) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.matches(encodedPassword, password);
	}

	public static String truncateStringToString(String str, int tailleMax) {
		String resultat = str;
		if (str.length() > tailleMax) {

			// final String OPEN_SPAN = "<span title=\"";
			// final String CLOSE_BALISE = "\">";
			// final String CLOSE_SPAN = "</span>";
			final String TROIS_POINT = "...";

			StringBuffer sb = new StringBuffer();
			// sb.append(OPEN_SPAN);
			// sb.append(str);
			// sb.append(CLOSE_BALISE);
			sb.append(str.substring(0, tailleMax));
			sb.append(TROIS_POINT);
			// sb.append(CLOSE_SPAN);
			resultat = sb.toString();
		}

		return resultat;

	}

	public static void redirectTo(String url) {
		try {
			ExternalContext ec = FacesContext.getCurrentInstance()
					.getExternalContext();
			ec.redirect(ec.getRequestContextPath() + url);
		} catch (IOException e) {
			LOG.debug("Récupération >>", e.toString());
		}
	}

	public static Integer dateDiffDate(Date date1, Date date2) {
		Calendar cal1 = new GregorianCalendar();
		cal1.setTime(date1);

		Calendar cal2 = new GregorianCalendar();
		cal2.setTime(date2);

		long diff = cal2.getTime().getTime() - cal1.getTime().getTime();

		return new Double(diff / (1000 * 60 * 60 * 24)).intValue();

	}
}
