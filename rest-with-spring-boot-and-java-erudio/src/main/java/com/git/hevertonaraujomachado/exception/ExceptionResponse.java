package com.git.hevertonaraujomachado.exception;

import java.util.Date;

//classe dados abstrato Java 16
public record ExceptionResponse(Date timestamp, String message, String details) {
}
