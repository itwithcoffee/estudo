package br.com.zago.exemplos.domain.enums;

public enum EstadoPagamento {
	
	PENDENTE (1, "Pendente"),
	QUITADO (2, "Quitado"),
	CANCELADO (3, "Cancelado");
	
	private Integer codigo;
	private String descricao;
	
	public Integer getCodigo() {
		return codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	
	private EstadoPagamento(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public static EstadoPagamento toEnum(Integer cod) {
		if (cod == null) {
			return null;
		} 
		for (EstadoPagamento ep : EstadoPagamento.values()) {
			if (cod.equals(ep.getCodigo())) {
				return ep;
			}
		}
		throw new IllegalArgumentException("ID inválido: " + cod);
	}
	
	
}
