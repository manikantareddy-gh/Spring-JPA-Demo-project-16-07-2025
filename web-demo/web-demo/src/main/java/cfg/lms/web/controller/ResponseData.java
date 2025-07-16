package cfg.lms.web.controller;

import lombok.Data;

@Data
public class ResponseData {
	private String status;
	private String message;
	private Object data;

}
