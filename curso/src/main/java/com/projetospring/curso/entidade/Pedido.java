package com.projetospring.curso.entidade;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projetospring.curso.entidade.enums.StatusPedido;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant momento;
	
	private Integer statusPedido;
	 
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private User cliente;

	@OneToMany(mappedBy = "id.pedido")
	private Set<PedidoItem> itens = new HashSet<>();
	
	@OneToOne(mappedBy = "pedido",cascade = CascadeType.ALL)
	private Pagamento pagamento;;
	
	public Pedido() {
		
	}
	public Pedido(Long id, Instant momento,StatusPedido statusPedido, User cliente) {
		super();
		this.id = id;
		this.momento = momento;
		setStatusPedido(statusPedido);;
		this.cliente = cliente;
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Instant getMomento() {
		return momento;
	}
	public void setMomento(Instant momento) {
		this.momento = momento;
	}
	public User getCliente() {
		return cliente;
	}
	public void setCliente(User cliente) {
		this.cliente = cliente;
	}
	public StatusPedido getStatusPedido() {
		return StatusPedido.valueof(statusPedido);
	}
	public void setStatusPedido(StatusPedido statusPedido) {
		if(statusPedido != null) {
		this.statusPedido = statusPedido.getCode();
		}
	}
	public Pagamento getPagamento() {
		return pagamento;
	}
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	public Set<PedidoItem> getItens(){
		return itens;
	}
	
	public Double getTotal() {
		double soma = 0.0;
		for (PedidoItem x : itens) {
			soma += x.getSubTotal();
		}
		return soma;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}
	
}
