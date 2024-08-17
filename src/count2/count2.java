package count2;

import java.util.Scanner;

public class count2 {
	public static void main(String[] args) {
		
		System.out.println("Enter the length of the array");
		Scanner input = new Scanner(System.in);
		int arrayLength = input.nextInt();
		int [] array = new int [arrayLength];
		int flag1 = 0;
		int flag2 = 0;
		int countArrayLength = 2;
		int [] countarray = new int [countArrayLength];
		int [] oldarray = new int [countArrayLength];
		
		for(int i = 0; i < arrayLength; i++) {					//read array elements
				int arrayElement = input.nextInt();
				array[i] = arrayElement;
		}
		
		for(int i = 0; i < arrayLength; i++) {
			flag2 = 0;
			for (int k = 0;k < countArrayLength;k += 2) {			
				if(array[i] == countarray[k]) {						//check if we counted the number before
					flag2 = 1;
				}
			}
			if (flag2 == 0) {
				for(int j = i + 1; j < arrayLength; j++) {
					if(array[i] == array[j]) {						//check if the number in our array
						flag1 = 0;
						for (int k = 0;k < countArrayLength;k += 2) {
							if(array[i] == countarray[k]) {
								countarray[k + 1]++;
								flag1 = 1;
								break;
							}
						}
						if(flag1 == 0){									//push new number into array 
							countArrayLength += 2;
							for(int l = 0; l < countArrayLength - 2; l++) {					
								oldarray[l] =  countarray[l];
							}
							countarray = new int [countArrayLength];
							for(int l = 0; l < countArrayLength - 2; l++) {					
								countarray[l] =  oldarray[l];
							}countarray[countArrayLength - 2] = array[i];
							countarray[countArrayLength - 1] = 2;
							oldarray = new int [countArrayLength];
						}
					}
				}
			}
		}
		
		for(int i = 2; i < countArrayLength; i+=2) {					//print result
			System.out.println(countarray[i]+"-->"+countarray[i+1]);
		}
	}
}
