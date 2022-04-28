package com.krungsri.register.exception;

import lombok.*;

@SuppressWarnings("serial")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class ApiException extends Exception{
	@NonNull String code;
	@NonNull String message;
	String description;
}
