package com.projet.type.view.util;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MessageFactory {

	private MessageFactory() {
	}

	public static FacesMessage getMessage(final Locale locale,
			final String messageId, final String head, final Object... params) {
		String summary = null;

		final FacesContext context = FacesContext.getCurrentInstance();
		final ResourceBundle bundle = context.getApplication()
				.getResourceBundle(context, "messages");

		try {
			summary = getFormattedText(locale, bundle.getString(messageId),
					params);
		} catch (final MissingResourceException e) {
			summary = messageId;
		}

		return new FacesMessage(head, summary);
	}

	public static FacesMessage getMessage(final String messageId,
			final String head, final FacesMessage.Severity severity,
			final Object... params) {
		final FacesMessage facesMessage = getMessage(getLocale(), messageId,
				head, params);
		facesMessage.setSeverity(severity);
		return facesMessage;
	}

	public static FacesMessage getMessage(final String messageId,
			final String head, final Object... params) {
		return getMessage(getLocale(), messageId, head, params);
	}

	private static String getFormattedText(final Locale locale,
			final String message, final Object[] params) {
		MessageFormat messageFormat = null;

		if (params == null || message == null) {
			return message;
		}

		messageFormat = locale == null ? new MessageFormat(message)
				: new MessageFormat(message, locale);
		return messageFormat.format(params);
	}

	private static Locale getLocale() {
		Locale locale = null;
		final FacesContext facesContext = FacesContext.getCurrentInstance();
		if (facesContext != null && facesContext.getViewRoot() != null) {
			locale = facesContext.getViewRoot().getLocale();
			if (locale == null) {
				locale = Locale.getDefault();
			}
		} else {
			locale = Locale.getDefault();
		}

		return locale;
	}
}
