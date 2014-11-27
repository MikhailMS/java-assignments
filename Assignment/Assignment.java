/*
Programme is written by Mikhail Molotkov, first year Software Engineer
Date of birth: 18/10/2014
Last update: 19/10/2014
*/

/*
 "vat" gets the first line from the text file
 "forCurrency" gets the second line from the text file
 "VAT_UK" is a constant for 20% UK VAT
 "vatFor" is a percent of VAT in foreign country
 "pound" stands for the amount of pounds to display
 "pence" stands for the amount of pences to display
 "mainCurrency" stands for the main part of foreign currency
 "smallCurrency" stands for the small part of foreign currency
 "money" is the amount of money from input
 "vatUK" is actual UK VAT for input
 "vatCurrency" is actual foreign VAT for input
 "positionUK" displays output for UK currency
 "positionForeign" displays output for foreign currency
*/

import sheffield.*;
public class Assignment {
		
	public static void main(String[] args) {
		
/*~~~~~~~~~~~~~~~~~~~~~~~~~~ Initialization of EasyReader and EasyWriter ~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
		EasyReader keyboard = new EasyReader();
		EasyReader fileInput = new EasyReader("rates.txt");
		EasyWriter screen = new EasyWriter();
/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

/*~~~~~~~~~~~~~~~~~~~~~~~~~~ Initialization of constant and variables ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
		final byte VAT_UK = 20;
		String vat, forCurrency;
		byte vatFor, positionUK=0, positionForeign=0;
		short pound=0, mainCurrency=0	;
		double money, vatUK, vatCurrency, pence=0, smallCurrency=0;
/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

/* ~~~~~~~~~~~~~~~~~~~~~~~~~ Input and main operations ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
		money = keyboard.readDouble("What is the price? ");
		vat = fileInput.readString();
		forCurrency = fileInput.readString();
		vatFor = Byte.valueOf(vat.substring(vat.lastIndexOf(" "),vat.length()-1).trim());
		vatUK = (VAT_UK * money)/(100 + VAT_UK);
		vatCurrency = (vatFor * money)/(100 + vatFor);
/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

/*~~~~~~~~~~~~~~~~~~~~~~~~~~ Split currency ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
		if ( money > 100 ) {
			pound =(short)(vatUK);
			pence =vatUK*100 - pound*100;
			mainCurrency =(short)(vatCurrency);
			smallCurrency =vatCurrency*100 - mainCurrency*100;
		}
		else if ( money > 1000 ) {
			pound =(short)(vatUK);
			pence =vatUK*1000 - pound*1000;
			mainCurrency =(short)(vatCurrency);
			smallCurrency =vatCurrency*1000 - mainCurrency*1000;
		}
		else if ( money > 10000 ) {
			pound =(short)(vatUK);
			pence =vatUK*10000 - pound*10000;
			mainCurrency =(short)(vatCurrency);
			smallCurrency =vatCurrency*10000 - mainCurrency*10000;
		}
		else {
			pound =(short)(vatUK);
			pence =vatUK*100 - pound*100;
			mainCurrency =(short)(vatCurrency);
			smallCurrency =vatCurrency*100 - mainCurrency*100;
		}
/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

/*~~~~~~~~~~~~~~~~~~~~~~~~~~ Checks for correct output ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
		if (vatUK < 10){
			positionUK =8;
		}
		else if (vatUK < 100) {
			positionUK =9;
		}
		else if (vatUK < 1000) {
			positionUK =10;
		}
		else {
			positionUK =11;
		}
		if (vatCurrency < 10){
			positionForeign =8;
		}
		else if (vatCurrency < 100) {
			positionForeign =9;
		}
		else if (vatCurrency < 1000) {
			positionForeign =10;
		}
		else {
			positionForeign =11;
		}
/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */		
		
/*~~~~~~~~~~~~~~~~~~~~~~~~~~ Output ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
		screen.println("The VAT on " + money + " is ");
		screen.print(vatUK,2,positionUK);
		screen.println(" in the UK");
		screen.print(vatCurrency,2,positionForeign);
		screen.println(" in "+vat.substring(vat.indexOf("in")+2, vat.indexOf("is")).trim());
		screen.println("The VAT on " + money + " is ");
		screen.print(pound + " pounds and ");
		screen.println(Math.round(pence) + " pence in the UK");
		screen.print(mainCurrency + " " + 
			forCurrency.substring(forCurrency.indexOf("uses")+4,forCurrency.indexOf("and")).trim() + " and ");
		screen.println(Math.round(smallCurrency) + " " +
			forCurrency.substring(forCurrency.indexOf("and")+3,forCurrency.length()).trim() +
			" in "+vat.substring(vat.indexOf("in")+2, vat.indexOf("is")).trim());
/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
	}
}