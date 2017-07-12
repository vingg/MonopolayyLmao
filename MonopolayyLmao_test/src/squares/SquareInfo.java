package squares;
//code taken from "hints" document
//contains values for squares, such as costs and associated rents

public class SquareInfo{
	
	public static final int NUM_SQUARES = 40;
	public static final int TYPE_GO = 0;
	public static final int TYPE_SITE = 1;
	public static final int TYPE_STATION = 2;
	public static final int TYPE_UTILITY = 3;
	public static final int TYPE_COMMUNITY = 4;
	public static final int TYPE_CHANCE = 5;
	public static final int TYPE_JAIL = 6;
	public static final int TYPE_PARKING = 7;
	public static final int TYPE_GO_TO_JAIL = 8;
	public static final int TYPE_TAX = 9;
	public static final int[] SQUARE_TYPES = {
	TYPE_GO, TYPE_SITE, TYPE_COMMUNITY, TYPE_SITE, TYPE_TAX, TYPE_STATION,
	TYPE_SITE, TYPE_CHANCE, TYPE_SITE, TYPE_SITE,
	TYPE_JAIL, TYPE_SITE, TYPE_UTILITY, TYPE_SITE, TYPE_SITE, TYPE_STATION,
	TYPE_SITE, TYPE_COMMUNITY, TYPE_SITE, TYPE_SITE,
	TYPE_PARKING, TYPE_SITE, TYPE_CHANCE, TYPE_SITE, TYPE_SITE,
	TYPE_STATION, TYPE_SITE, TYPE_SITE, TYPE_UTILITY, TYPE_SITE,
	TYPE_GO_TO_JAIL, TYPE_SITE, TYPE_SITE, TYPE_COMMUNITY, TYPE_SITE,
	TYPE_STATION, TYPE_CHANCE, TYPE_SITE, TYPE_TAX, TYPE_SITE};
	public static final String[] SQUARE_TYPE_NAMES = {
		"Go", "Site", "Station", "Utility", "Community", "Chance", 
		"Jail", "Parking", "Go To Jail", "Tax" };
	public static final String GO_NAME = "GO";
	// below specifically refers to regular sites - not stations etc.
	public static final String[] SITE_NAMES = {
	"Old Kent Rd", "Whitechapel Rd", "The Angel Islington", "Euston Rd", 
	"Pentonville Rd", "Pall Mall", "Whitehall", "Northumberland Ave", "Bow St", 
	"Marlborough St", "Vine St", "Strand", "Fleet St", "Trafalgar Sq", 
	"Leicester Sq", "Coventry St", "Piccadilly",
	"Regent St", "Oxford St", "Bond St", "Park Lane", "Mayfair"};
	public static final String[] SITE_SHORT_NAMES = {
	"kent", "whitechapel", "angel", "euston", "pentonville",
	"mall", "whitehall", "northumberland", "bow", "marlborough", "vine",
	"strand", "fleet", "trafalgar", "leicester", "coventry", "piccadilly",
	"regent", "oxford", "bond", "ark", "mayfair"};
	public static final int[] SITE_PRICES = {
	60,60,100,100,120,
	140,140,160,180,180,200,
	220,220,240,260,260,280,
	300,300,320,350,400};
	public static final int[][] SITE_RENTS = {
	{2,10,30,90,160,250},{4,20,60,180,320,450},{6,30,90,270,400,550},{6,30,90,270,
	400,550},{8,40,100,300,450,600},
	{10,50,150,450,625,750},{10,50,150,450,625,750},{12,60,180,500,700,900},{14,70
	,200,550,750,950},{25,50,100,200,200,200},{14,70,200,550,750,950},{16,80,220,600,800,1000},
	{18,90,250,700,875,1050},{4,10,0,0,0,0},{18,90,250,700,875,1050},{25,50,100,200,200,200},
	{20,100,300,750,925,1100},{25,50,100,200,200,200},{22,110,330,800,975,1150}
	,{22,110,330,800,975,1150},{22,120,360,850,1025,1200},
	{26,130,390,900,1100,1275},{26,130,390,900,1100,1275},{28,150,450,1000,1200,1400},
	{25,50,100,200,200,200},{35,175,500,1100,1300,1500}};
	public static final int[] HOUSE_PRICE = {
	50,50,50,50,50,
	100,100,100,100,100,100,
	150,50,150,150,150,150,150,
	200,200,200,200,200};
	public static final int[] SITE_MORTGAGE_VALUE = {
	50,50,50,50,60,
	70,70,80,90,90,100,
	110,110,120,150,150,150,
	200,200,200,175,200};
	public static final String[] STATION_NAMES = {
	"King's Cross Station",
	"Marylebone Station",
	"Fenchurch St Station",
	"Liverpool St Station"};
	public static final String[] STATION_SHORT_NAMES =
	{ "kings", "marylebone", "fenchurch", "liverpool"};
	public static final int STATION_PRICE = 200;
	public static final int[] STATION_RENTS = {25,50,100,200,200,200};
	public static final int STATION_MORTGAGE_VALUE = 100;
	public static final String[] UTILITY_NAMES = { "Electric Co", "Water Works"};
	public static final String[] UTILITY_SHORT_NAMES = { "electric", "water"};
	public static final int UTILITY_PRICE = 150;
	public static final int[] UTILITY_RENTS = {4,10};
	public static final int UTILITY_MORTGAGE_VALUE = 75;
	public static final String COMMUNITY_NAME = "Community Chest";
	public static final String CHANCE_NAME = "Chance";
	public static final String JAIL_NAME = "Jail (Just Visiting)";
	public static final String PARKING_NAME = "Free Parking";
	public static final String GO_TO_JAIL_NAME = "Go To Jail";
	public static final String VISITING_JAIL_NAME = "Just Visiting";
	public static final String[] TAX_NAMES = { "Income Tax", "Super Tax"};
	public static final int[] TAX_AMOUNTS = {200,100};
	public static final int COL_BROWN = 0;
	public static final int COL_LIGHT_BLUE = 1;
	public static final int COL_PINK = 2;
	public static final int COL_ORANGE = 3;
	public static final int COL_RED = 4;
	public static final int COL_YELLOW = 5;
	public static final int COL_GREEN = 6;
	public static final int COL_DARK_BLUE = 7;
	public static final int[] SITE_COLOURS = {
	COL_BROWN, COL_BROWN, COL_LIGHT_BLUE, COL_LIGHT_BLUE, COL_LIGHT_BLUE,
	COL_PINK, COL_PINK, COL_PINK, COL_ORANGE, COL_ORANGE, COL_ORANGE,
	COL_RED, COL_RED, COL_RED, COL_YELLOW, COL_YELLOW, COL_YELLOW,
	COL_GREEN, COL_GREEN, COL_GREEN, COL_DARK_BLUE, COL_DARK_BLUE};
	public static final String[] COLOUR_GROUP_NAME = { "brown", "light blue",
			"pink", "orange", "red", "yellow", "green", "dark blue"};
	public static final int[] NUM_IN_GROUP = {2,3,3,3,3,3,3,2};
	
	/**
	 * find the property number matching the name of the input string
	 * returns -1 if this property does not exist
	 */
	
	public static int findPropertyNum(String propertyName){
		int i = -1;
		boolean check = false;
		while(i<SITE_NAMES.length-1 && !check){
			if(propertyName.equalsIgnoreCase(SITE_NAMES[++i])) check=true;
		}
		if (!check) return -1;
		else return i;
	}
	public static int findShortPropertyNum(String propertyShortName){
		int i = -1;
		boolean check = false;
		//first find the site number
		while(i<SITE_SHORT_NAMES.length-1 && !check){
			if(propertyShortName.equalsIgnoreCase(SITE_SHORT_NAMES[++i])) check=true;
		}
		if (!check) return -1;
		//then find where that is on the board
		else{
			int j = 0, num = -1;
			while(j<i+1){
				if(SQUARE_TYPES[++num]==1) j++;
			}
			return num;
		}
	}
}