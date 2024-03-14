
public class One_D_Array {
		public static void main(String[] args) {
			//Road 1 ở đây cách khai báo này của mình nhất chi phức tạp
			//khác với C chỉ cần khai báo số mảng, sau đó gán giá trị từng dòng trong mảng chạy 
			String[] food = {" " ," " ," " ," " }; 
			food[0] = "Banana";
			food[1] = "Campuchia";
			food[2] = "Sandwitch";
			food[3] = "Dooki";
			System.out.println(food[0]);
			
			int[] food1 = { 0, 0, 0, 0};
			food1[0] = 1;
			food1[1] = 2;
			food1[2] = 3;
			food1[3] = 4;
			
			//**Road 2** ko được ghi kích thước mảng trong String vd String[5] là error
			String[] food2 = {"Banana", "Campuchia", "Sandwitch", "Dooki"};
			int[] food3 = {1, 2, 3, 4};
			
			/***Road 3*** cách này thì string bên vế phải nó đòi hỏi 
			kích thước size lớn hơn hoặc bằng số phần tử khai báo*/
			String[] food4 = new String[5];
			food4[0] = "Banana";
			food4[1] = "Campuchia";
			food4[2] = "Sandwitch";
			food4[3] = "Dooki";	
		}
	}

