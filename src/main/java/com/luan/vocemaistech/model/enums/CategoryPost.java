package com.luan.vocemaistech.model.enums;

public enum CategoryPost {

	PROGRAMACAO(0, "PROGRAMACAO"), SOCIALMEDIA(1, "SOCIALMEDIA"), UTILIDADES(2, "UTILIDADES");

	private Integer code;
	private String description;

	private CategoryPost(Integer code, String description) {
		this.code = code;
		this.description = description;
	}

	public Integer getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public static CategoryPost toEnum(String desc) {
		if (desc == null) {
			return null;
		}
		for (CategoryPost x : CategoryPost.values()) {
			if (desc.equals(x.getDescription())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Categoria Inválida");
	}

}
