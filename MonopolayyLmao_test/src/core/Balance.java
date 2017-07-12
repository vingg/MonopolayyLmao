package core;

import squares.Square;
import squares.SquareInfo;

//contains all the player's money and property.

public class Balance {
	private int balance;
	private int[] amountOfEachColorGroup = new int[8];
	PropertyList properties;
	//implemented as a map
	public class PropertyList{
		private Node first;
		private int numProperties=0;
		protected class Node{
			Square property;
			Node next;
			
			Node(Square s, Node n){
				property = s;
				next = n;
			}
			public boolean hasNext(){
				return (next != null);
			}
			public Node getNext(){
				if(hasNext())return next;
				return null;
			}
			public void setNext(Node input){
				next = input;
			}
		}
		/**
		 * checks if the set matching input square is fully owned by this player
		 */
		public boolean checkForColorSet(Square square){
			if(square.getSquareType()!=1) return false;
			
			int checkColor = square.getColor();
			if(amountOfEachColorGroup[checkColor]==SquareInfo.NUM_IN_GROUP[checkColor]) return true;
			else return false;
		}
		
		public boolean isEmpty(){
			return(first==null);
		}
		public Node first(){
			return first;
		}
		public Node last(){
			if(first== null || first.getNext()==null) return first;
			Node temp = first;
			while(temp.hasNext()){
				temp = temp.next;
			}
			return temp;
		}
		public Node get(int propertyNum){
			Node temp = first();
			while(temp.property.getSquareNum()!=propertyNum && temp!=null){
				temp=temp.getNext();
			}
			return temp;
		}
		public Square getSquare(int propertyNum){
			Node temp =  get(propertyNum);
			if(temp!=null) return temp.property;
			else return null;
		}
		public Square[] getColorGroup(int colorGroup){
			Node temp = first();
			int check=0, numInGroup = SquareInfo.NUM_IN_GROUP[colorGroup];
			Square squares[] = new Square[numInGroup];
			while(check<numInGroup && temp!=null){
				if(temp.property.getColor()==colorGroup) squares[check++] = temp.property;
				temp=temp.getNext();
			}
			return squares;
		}
		public void insert(Square square){
			numProperties++;
			Node newNode = new Node(square, null);
			if(square.getSquareType()==1) ++amountOfEachColorGroup[square.getColor()];
			if(isEmpty()){
				first = newNode;
				return;
			}
			else{
				last().setNext(newNode);
				//if the square is a site, check if a set has been completed
				if(square.getSquareType()==1) checkForColorSet(square);
				return;
			}
		}
		public Square remove(int propertyNum){
			numProperties--;
			Node oldNode = get(propertyNum);
			if(isEmpty() || oldNode==null) return null;
			if(oldNode.property.getSquareType()==1) --amountOfEachColorGroup[oldNode.property.getColor()];
			if(first().equals(oldNode)){
				first = first.next;
				if(oldNode.property.getSquareType()==1) checkForColorSet(oldNode.property);
				return oldNode.property;
			}
			Node prev = first(), next = oldNode.next;
			while(!prev.next.equals(oldNode)){
				prev = prev.next;
			}
			prev.setNext(next);
			if(oldNode.property.getSquareType()==1) checkForColorSet(oldNode.property);
			return oldNode.property;
		}
		public int getPropertyNum(){
			return numProperties;
		}
		public String toString(){
			String outString = numProperties + " properties:\n";
			Node temp = first();
			while(temp!=null){
				outString += temp.property.getName();// + "\n";
				if(temp.property.getSquareType()==1){
					outString += "(" + SquareInfo.COLOUR_GROUP_NAME[temp.property.getColor()] + ")\n";
				}
				else outString += "(" + SquareInfo.SQUARE_TYPE_NAMES[temp.property.getSquareType()] + ")\n";
				temp=temp.next;
			}
			return outString;
		}
		
	}
	Balance(){
		balance = 1500;
		properties = new PropertyList();
	}

	public int getBalance(){
		return balance;
	}
	
	public String showAllProperty(){
		return properties.toString();
	}
	
	
	public int addBalance(int amount){
		balance+=amount;
		return balance;
	}
	
	public int subtractBalance(int amount){
		return addBalance((amount*-1));
	}
	
	public void addProperty(Square square){
		properties.insert(square);
	}
	
}
