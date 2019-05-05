import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.List;
public class Estada {
	private Calendar dataEntrada;
	private Calendar dataSaida;
	private boolean pagamentoConcluido;
	private Calendar tempoDePermanencia;
	private String placa;
	private static int qtdVeiculosEstacionados;
	private Estacionamento est;
	private Valores val; 
	
	public Estada() {
		qtdVeiculosEstacionados++;
	}
	public int calcQtdeEstadas() {
		int vagas  = est.getQtdVagas() - est.getQtdVeiculosEstacionados();
		return vagas;
	}
	public String calcTempo() {
		int ano,mes,dia,hora,minutos;
			ano =  dataSaida.YEAR - dataEntrada.YEAR ;
		mes = - dataSaida.MONTH - dataEntrada.MONTH ;
		dia = dataSaida.DAY_OF_MONTH - dataEntrada.DAY_OF_MONTH;
		hora = dataSaida.HOUR - dataEntrada.HOUR;
		minutos = dataSaida.MINUTE - dataEntrada.MINUTE;
		
//		if(ano==0)return "/"+mes+"/"+dia+" "+hora+":"+minutos; 
//		if(mes==0)return "/"+dia+" "+hora+":"+minutos;
//		if(dia==0)return " "+hora+":"+minutos;
//		if(hora==0)return ""+minutos;
		
		return ""+ano+"/"+mes+"/"+dia+" "+hora+":"+minutos;
	}
	
	
	
	
//	public String calcTempo() {
//	      //set calendar to 6th March 2009
//
//		Calendar calendarAux = new GregorianCalendar();
//	      calendarAux = dataSaida;
//	      //Subtract 4 months,5 days,12 hours and 24 minutes
//	      calendarAux.
//	      calendarAux.add(Calendar.MONTH, - dataEntrada.MONTH);
//	      calendarAux.add(Calendar.DAY_OF_MONTH, - dataEntrada.DAY_OF_MONTH);
//	      calendarAux.add(Calendar.HOUR, - dataEntrada.HOUR );
//	      calendarAux.add(Calendar.MINUTE, - dataEntrada.MINUTE);
//	      
//	   	int ano,mes,dia,hora,minutos;
//    
//    	ano = calendarAux.get(GregorianCalendar.YEAR);
//    	mes = calendarAux.get(GregorianCalendar.MONTH);
//    	dia = calendarAux.get(GregorianCalendar.DAY_OF_MONTH);
//    	hora = calendarAux.get(GregorianCalendar.HOUR);
//    	minutos = calendarAux.get(GregorianCalendar.MINUTE);
//    	
//   	    return ""+ano+"/"+mes+"/"+dia+" "+hora+":"+minutos;
//	      
//	   }
	
	
	public boolean isPagamentoConcluido() {
		return pagamentoConcluido;
	}
	public void setPagamentoConcluido(boolean pagamentoConcluido) {
		this.pagamentoConcluido = pagamentoConcluido;
	}
	public Calendar getTempoDePermanencia() {
		return tempoDePermanencia;
	}
	public void setTempoDePermanencia(Calendar tempoDePermanencia) {
		this.tempoDePermanencia = tempoDePermanencia;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Calendar getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Calendar dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public Calendar getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(Calendar dataSaida) {
		this.dataSaida = dataSaida;
	}
	
	
	
}
