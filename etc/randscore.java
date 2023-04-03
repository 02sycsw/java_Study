public class randscore {
	public static void main(String[] args) {
		int[][] scores = new int[5][7];
		int[] sum = new int[scores.length];
		double[] avg = new double[scores.length];
		
		for(int i = 0; i<scores.length; i++) {
			for(int j = 0; j<scores[i].length; j++) {
				scores[i][j] = (int)(Math.random()*101);
				//Math.random은 0~1인데 여기에 101을 곱하면 최대값이 100까지 나오고
				//100을 곱하고 1을 더하면 최소값은 1이고 최대값은 100이다. 
				
				for(int k = 0; k < j; k++) {
					if(scores[i][k] == scores[i][j]) {
						j--;
						//System.out.print(scores[i][j] + " ");
						break;
					}
				}
				System.out.print(scores[i][j] + " ");
			}
			System.out.println("");
		}
		
		for(int i = 0; i<scores.length; i++) {
			for(int j = 0; j<scores[i].length; j++) {
				sum[i] += scores[i][j];
			}
			avg[i] = (double)sum[i]/scores[i].length;
			System.out.println(i+1 + "번 학생의 점수의 합계는 "+sum[i] + 
					"점, 평균은 " + avg[i] + "점입니다.");
		}
	}

}
