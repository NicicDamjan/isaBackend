package ftn.isa.booking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "AirlineConfiguration")
public class AirlineConfiguration implements Serializable {

    @Id
    @GeneratedValue
    private  Long id;

    @Column(name = "Arange",nullable = false)
    private Double arange;

    @Column(name = "RowsA", nullable = false)
    private Double rowsA;

    @Column(name = "ColumnsA", nullable = false)
    private Double columnsA;
   
    public AirlineConfiguration() {
    	
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

 

    public Double getArange() {
		return arange;
	}


	public void setArange(Double arange) {
		this.arange = arange;
	}


	public Double getRowsA() {
		return rowsA;
	}


	public void setRowsA(Double rowsA) {
		this.rowsA = rowsA;
	}


	public Double getColumnsA() {
		return columnsA;
	}


	public void setColumnsA(Double columnsA) {
		this.columnsA = columnsA;
	}


	
	

}
