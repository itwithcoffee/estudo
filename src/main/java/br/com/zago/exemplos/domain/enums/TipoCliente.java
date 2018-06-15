package br.com.zago.exemplos.domain.enums;

public enum TipoCliente {

	PESSOA_FISICA (1, "Pessoa Física"),
	PESSOA_JURIDICA (2, "Pessoa Jurídica");
	
	private Integer codigo;
	private String descricao;
	
	private TipoCliente(Integer cod, String desc) {
		codigo = cod;
		descricao = desc;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		if (cod == null) {
			return null;
		} 
		for (TipoCliente tc : TipoCliente.values()) {
			if (cod.equals(tc.getCodigo())) {
				return tc;
			}
		}
		throw new IllegalArgumentException("ID inválido: " + cod);
	}
}
