import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
public class Aplicacao {

    public static void main(String[] args) {
        
    	Estacionamento estacionamento = criarEstabelecimento();
    	
        cadastroVeiculo(estacionamento);
        saidaVeiculo(estacionamento);
          
    }

    public static void cadastroVeiculo(Estacionamento estacionamento) {
    	Calendar c = new GregorianCalendar();
    	c.set(2019, 5, 5, 15, 30);
    	Estada estada = new Estada();    	
    	String placa = JOptionPane.showInputDialog("Placa: ");
        estada.setPlaca(placa);
        estada.setDataEntrada(c);
        estacionamento.estadaList.put(placa, estada);
//        estacionamento.estadaList.put(placa, estada);
        
    }
    
    public static void saidaVeiculo(Estacionamento estacionamento) {
    	String placa = JOptionPane.showInputDialog("Placa: ");
    	Estada estadaSaida = estacionamento.estadaList.get(placa);
    	estadaSaida.setDataSaida(receberHora());
    	String saida = "Tempo Decorrido:"+estadaSaida.calcTempo()+ "\n"+"Placa:"+estadaSaida.getPlaca();
    	JOptionPane.showMessageDialog(null, saida);
    }
    
   
    public static Calendar receberHora() {
//    	int ano,mes,dia,hora,minutos;
    	Calendar calendar = new GregorianCalendar();
//    	ano = calendar.get(GregorianCalendar.YEAR);
//    	mes = calendar.get(GregorianCalendar.MONTH)+1;
//    	dia = calendar.get(GregorianCalendar.DAY_OF_MONTH);
//    	hora = calendar.get(GregorianCalendar.HOUR);
//    	minutos = calendar.get(GregorianCalendar.MINUTE);
//    	return ""+ano+"/"+mes+"/"+dia+" "+hora+":"+minutos;
    	return calendar;
    }
    
    
    
    public static Estacionamento criarEstabelecimento() {

        String nomeEstabelecimento = JOptionPane.showInputDialog("Nome do Estacionamento: ");
        String openingTime = JOptionPane.showInputDialog("Hora de abertura: (hh:mm)");
        String closureTime = JOptionPane.showInputDialog("Hora do fechamento: (hh:mm)");
        String qtdVagas = JOptionPane.showInputDialog("Quantidade de vagas: ");

        Integer horaAberturaFormatado = Integer.parseInt(openingTime.substring(0,2));
        Integer minutoAberturaFormatado = Integer.parseInt(openingTime.substring(3));
        Integer horaFechamentoFormatado = Integer.parseInt(closureTime.substring(0,2));
        Integer minutoFechamentoFormatado = Integer.parseInt(closureTime.substring(3));

        int vagas = Integer.parseInt(qtdVagas);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        Calendar horaAbertura = Calendar.getInstance();
        horaAbertura.set(Calendar.HOUR_OF_DAY,horaAberturaFormatado);
        horaAbertura.set(Calendar.MINUTE,minutoAberturaFormatado);

        Calendar horaFechamento = Calendar.getInstance();
        horaFechamento.set(Calendar.HOUR_OF_DAY,horaFechamentoFormatado);
        horaFechamento.set(Calendar.MINUTE,minutoFechamentoFormatado);

        Valores valoresEstabelecimento = definirValoresEstabelecimento();

        Estacionamento parking = new Estacionamento(nomeEstabelecimento,
                sdf.format(horaAbertura.getTime()),
                sdf.format(horaFechamento.getTime()),
                vagas,
                valoresEstabelecimento, null);

        JOptionPane.showMessageDialog(null, parking.toString());
        return parking;
    }

    public static Valores definirValoresEstabelecimento () {
        Double valorHora = null;
        Double fracaoQuinze = 0.0;
        Double valorDiaria = 0.0;
        Double valorMensal = 0.0;
        Double perNoite = 0.0;


        valorHora = Double.parseDouble(JOptionPane.showInputDialog(null,"Informe o valor da hora: ","Definindo Valores",JOptionPane.QUESTION_MESSAGE));


        int checkValores = JOptionPane.showConfirmDialog(null,
                "Deseja definir outras opcoes de valores?\n(Quinze minutos, diaria, mensal, pernoite)", "Definindo Valores",JOptionPane.YES_NO_OPTION);

        if (checkValores == 0) {
            int checkFracao = JOptionPane.showConfirmDialog(null,
                    "Definir valor para Fracao 15 minutos?", "Definindo Valores", JOptionPane.YES_NO_OPTION);
            if (checkFracao == 0)
                fracaoQuinze = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o valor: ", "Definindo valor fracao quinze minutos", JOptionPane.QUESTION_MESSAGE));


            int checkDiaria = JOptionPane.showConfirmDialog(null,
                    "Definir valor para diaria?", "Definindo Valores", JOptionPane.YES_NO_OPTION);
            if (checkDiaria == 0)
                valorDiaria = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o valor: ", "Definindo valor da diaria", JOptionPane.QUESTION_MESSAGE));


            int checkMensal = JOptionPane.showConfirmDialog(null,
                    "Definir valor para mensalidade?", "Definindo Valores", JOptionPane.YES_NO_OPTION);
            if (checkMensal == 0)
                valorMensal = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o valor: ", "Definindo valor mensal", JOptionPane.QUESTION_MESSAGE));


            int checkNoite = JOptionPane.showConfirmDialog(null,
                    "Definir valor para pernoite?", "Definindo Valores", JOptionPane.YES_NO_OPTION);
            if (checkNoite == 0)
                perNoite = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o valor: ", "Definindo o valor pernoite", JOptionPane.QUESTION_MESSAGE));

        }
        
        Valores v = new Valores(valorHora,fracaoQuinze,valorDiaria,valorMensal,perNoite);

       // JOptionPane.showMessageDialog(null,v.toString(),"Valores definidos",JOptionPane.PLAIN_MESSAGE);

        return v;

    }
}
