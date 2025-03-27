/*TP 2.2 Ordenamiento y búsqueda
        Cree una clase JJOO que contenga la siguiente información:
        País, Cantidad de medallas de Bronce, Cantidad de medallas de plata, Cantidad de medallas de oro,
        lugar del ranking.
        Defina un comparador que considere lo siguiente los países se ordenan por cantidad de medallas de
        oro, si 2 países tienen la misma cantidad de oros se comparan las platas, si también tienen la misma
        cantidad de platas se comparan por bronces, en caso de coincidir, se colocan en orden alfabético.
        Cree los métodos cargar y mostrar.
        Luego agregue 2 de los métodos estudiados para ordenamiento a su elección.
        Escriba un menú. Se espera que muestre los elementos en el orden ingresado y luego de ordenarlos, el
        usuario debe poder elegir el método.
        También tiene que mostrar el tiempo que insume el ordenamiento.*/

import java.util.Arrays;

public class JuegosOlimpicos implements Comparable<JuegosOlimpicos> {
    private String pais;
    private Integer medallasOro;
    private Integer medallasPlata;
    private Integer medallasBronce;
    private Integer lugarRaking;

    public JuegosOlimpicos(String pais, Integer medallasOro, Integer medallasPlata, Integer medallasBronce, Integer lugarRaking) {
        this.pais = pais;
        this.medallasOro = medallasOro;
        this.medallasPlata = medallasPlata;
        this.medallasBronce = medallasBronce;
        this.lugarRaking = lugarRaking;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getMedallasOro() {
        return medallasOro;
    }

    public void setMedallasOro(Integer medallasOro) {
        this.medallasOro = medallasOro;
    }

    public Integer getMedallasPlata() {
        return medallasPlata;
    }

    public void setMedallasPlata(Integer medallasPlata) {
        this.medallasPlata = medallasPlata;
    }

    public Integer getMedallasBronce() {
        return medallasBronce;
    }

    public void setMedallasBronce(Integer medallasBronce) {
        this.medallasBronce = medallasBronce;
    }

    public Integer getLugarRaking() {
        return lugarRaking;
    }

    public void setLugarRaking(Integer lugarRaking) {
        this.lugarRaking = lugarRaking;
    }

    @Override
    public String toString() {
        return "  * " +
                "pais '" + pais +
                ", medallas de Oro= " + medallasOro +
                ", medallas de Plata= " + medallasPlata +
                ", medallas de Bronce= " + medallasBronce +
                ", lugar en el Raking=" + lugarRaking +".";
    }

    // usar CompareTo y acceder a la opc cuales atributos se usaran p/ordenar
    @Override
    public int compareTo(JuegosOlimpicos juegoQueSeComparara) {
        int comparacionOro = medallasOro.compareTo(juegoQueSeComparara.getMedallasOro());
        if (comparacionOro != 0) {
            return -comparacionOro; // Negativo para ordenar de mayor a menor
        }

        int comparacionPlata = medallasPlata.compareTo(juegoQueSeComparara.getMedallasPlata());
        if (comparacionPlata != 0) {
            return -comparacionPlata;
        }

        int comparacionBronce = medallasBronce.compareTo(juegoQueSeComparara.getMedallasBronce());
        if (comparacionBronce != 0) {
            return -comparacionBronce;
        }

        return pais.compareToIgnoreCase(juegoQueSeComparara.getPais());
    }

    public static JuegosOlimpicos cargar(String pais, Integer oro, Integer plata, Integer bronce, Integer ranking) {
        return new JuegosOlimpicos(pais, oro, plata, bronce, ranking);
    }


    public static void bubbleSort(JuegosOlimpicos[] array) {
        int len = array.length;
        boolean cambiarPositionDeOrden;
        for (int i = 0; i < len - 1; i++) {
            cambiarPositionDeOrden = false;
            for (int j = 0; j < len - 1; j++) {
                // se compara obj en array. En compareTo se considera la posicion
                // dentro del array y se compara con num 0 igual, - menor, + ma
                if (array[j].compareTo(array[j + 1]) > 0) {
                    JuegosOlimpicos temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    cambiarPositionDeOrden = true;
                }
            }
            if (!cambiarPositionDeOrden) {
                break;
            }
        }
    }

    public static void insertionSort(JuegosOlimpicos[] array) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            JuegosOlimpicos varTemporal = array[i];
            int j = i - 1;
            // Mover los elementos de datos[0...i-1] que son mayores que varTemporal
            // una posición adelante de su posición actual
            while (j >= 0 && array[j].compareTo(varTemporal)>0 ){
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = varTemporal;
        }
    }
    public static void shellSort(JuegosOlimpicos[] array) {
        int len = array.length;

        // intervalo inicial
        for (int intervalo = len / 2; intervalo > 0; intervalo /= 2) {
            for (int i = intervalo; i < len; i++) {
                JuegosOlimpicos varTemporal = array[i];
                int j = i;

                // Se compara obj en array usando compareTo, determinado por el intervalo
                while (j >= intervalo && array[j - intervalo].compareTo(varTemporal) > 0) {
                    array[j] = array[j - intervalo];
                    j -= intervalo;
                }
                array[j] = varTemporal;
            }
        }
    }

    public static void muestraArrayOrdenado (JuegosOlimpicos[] array) {
        System.out.println(Arrays.toString(array));
    }

}
