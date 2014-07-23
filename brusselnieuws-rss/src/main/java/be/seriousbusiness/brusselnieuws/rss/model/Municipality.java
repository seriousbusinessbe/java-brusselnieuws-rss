package be.seriousbusiness.brusselnieuws.rss.model;

public enum Municipality {
	ANDERLECHT("Anderlecht"),
	BRUSSEL_STAD("Brussel-Stad"),
	ELSENE("Elsene"),
	ETTERBEEK("Etterbeek"),
	EVERE("Evere"),
	GANSHOREN("Ganshoren"),
	HAREN("Haren"),
	JETTE("Jette"),
	KOEKELBERG("Koekelberg"),
	LAKEN("Laken"),
	NEDER_OVER_HEEMBEEK("Neder-Over-Heembeek"),
	OUDERGEM("Oudergem"),
	SCHAARBEEK("Schaarbeek"),
	SINT_AGATHA_BERCHEM("Sint-Agatha-Berchem"),
	SINT_GILLIS("Sint-Gillis"),
	SING_JANS_MOLENBEEK("Sint-Jans-Molenbeek"),
	SINT_JOOST_TEN_NODE("Sint-Joost-ten-Node"),
	SINT_LAMBRECHTS_WOLUWE("Sint-Lambrechts-Woluwe"),
	SINT_PIETERS_WOLUWE("Sint-Pieters-Woluwe"),
	UKKEL("Ukkel"),
	VORST("Vorst"),
	WATERMAAL_BOSVOORDE("Watermaal-Bosvoorde");
	
	private String nameNl,nameFr,nameDe;
	private Municipality(final String nameNl){
		this.nameNl=nameNl;
	}
	
	public String nameNl(){
		return nameNl;
	}
	
	public String nameFr(){
		return nameFr;
	}
	
	public String nameDe(){
		return nameDe;
	}

}
