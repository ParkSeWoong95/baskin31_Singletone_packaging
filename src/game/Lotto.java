package game;

import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import user.IUserService;
import user.IUserServiceImpl;
import user.UserVO;

public class Lotto {
	/**
	 * 숫자 입력 메서드
	 * 
	 * @author 이학재
	 * @return int - 입력받은 숫자
	 */
	int iInput() {
		int input;
		while (true) {
			try {
				Scanner scanner = new Scanner(System.in);
				input = scanner.nextInt();
				break;
			} catch (Exception e) {
				System.out.println();
				System.out.println("숫자만 입력해주세요.");
			}
		}
		return input;
	}

	public void lotto(String user_id) {
		//		지금 플레이하는 유저 정보를 가져오자.
		IUserService iUserService = IUserServiceImpl.getInstance();
		UserVO user = iUserService.selectUser(user_id);

		//		플레이 게임 수와 방법을 선택하자.
		int input;
		int method;

		//		자동이든 수동이든 일단 선택한 값이 있어야 추첨이 가능하겠지.
		//		일단 가져오자.
		List<Set<Integer>> selectLotto;

		//		추첨 결과를 만들어보자.
		//		보너스숫자는 따로 관리해야하겠지.
		Set<Integer> raffle = new HashSet<>();
		int bonus;
		
		// 역대 당첨 번호를 모두 한 리스트에 꼬라박는 방식으로 가중치 부여
		List<Integer> parseLotto = new ArrayList<>();
		
		while (true) {
			System.out.println("플레이 할 게임 수를 입력하세요. ( 1 ~ 5 회 )");
			System.out.println("게임 당 1000원의 요금이 발생합니다.");
			input = iInput();
			if (input == 0) {
				System.out.println("게임을 취소합니다.");
				return;
			} else if (input > 0 && input <= 5) {
				break;
			}
			System.out.println("올바른 숫자가 아닙니다.");
		}

		if (user.getPoint() < input * 1000) {
			System.out.println("돈도없는게 ...");
			return;
		}
		
		Map<String, Object> updateUser = new HashMap<>();
		updateUser.put("user_id", user_id);
		updateUser.put("user_point", user.getPoint() - input * 1000);
		iUserService.updateUser(updateUser);

		while (true) {
			System.out.println("게임 플레이 방법을 선택하세요.");
			System.out.println("[ 1 ] 수동");
			System.out.println("[ 2 ] 자동");
			method = iInput();
			if (method == 1) {
				selectLotto = selectLotto(input);
				break;
			} else if (method == 2) {
				selectLotto = autoSelectLotto(input);
				break;
			}
			System.out.println("올바른 숫자가 아닙니다.");
		}

		System.out.println("추첨을 시작합니다.");

		for (int i = 0; i < 948; i++) {
			try {
				System.out.print(i + 1 + "회차 결과");
				List<Integer> parseLottoPart = parseLotto(i);
				System.out.println(parseLottoPart);
				parseLotto.addAll(parseLottoPart);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("추첨 시작");
		while (raffle.size() < 6) {
			raffle.add(parseLotto.get((int) (Math.random() * parseLotto.size())));
		}
		
		while (true) {
			bonus = parseLotto.get((int) (Math.random() * parseLotto.size()));
			if (!raffle.contains(bonus)) {
				break;
			}
		}
		
		List<Integer> raffleResult = new ArrayList<>(raffle);
		Collections.sort(raffleResult);
		
		System.out.println("추첨 결과 : " + raffleResult);
		System.out.println("보너스 숫자 : " + bonus);
		for (int i = 0; i < selectLotto.size(); i++) {
			int result = 0;
			for (Integer raffleNum : raffleResult) {
				if (selectLotto.get(i).contains(raffleNum)) {
					result++;
				}
			}
			
			System.out.println(i + 1 + "번째 게임 결과입니다.");
			if (result == 6) {
				System.out.println("1등 당첨을 축하합니다.");
				System.out.println("당첨금은 10억원입니다.");
				
				Map<String, Object> userObj = new HashMap<>();
				userObj.put("user_id", user_id);
				userObj.put("user_point", 1000000000);
				iUserService.addPoint(userObj);
			} else if (result == 5 && selectLotto.get(i).contains(bonus)) {
				System.out.println("2등 당첨을 축하합니다.");
				System.out.println("당첨금은 4천만원입니다.");
				
				Map<String, Object> userObj = new HashMap<>();
				userObj.put("user_id", user_id);
				userObj.put("user_point", 40000000);
				iUserService.addPoint(userObj);
			} else if (result == 5) {
				System.out.println("3등 당첨을 축하합니다.");
				System.out.println("당첨금은 300만원입니다.");
				
				Map<String, Object> userObj = new HashMap<>();
				userObj.put("user_id", user_id);
				userObj.put("user_point", 3000000);
				iUserService.addPoint(userObj);
			} else if (result == 4) {
				System.out.println("4등 당첨을 축하합니다.");
				System.out.println("당첨금은 5만원입니다.");
				
				Map<String, Object> userObj = new HashMap<>();
				userObj.put("user_id", user_id);
				userObj.put("user_point", 50000);
				iUserService.addPoint(userObj);
			} else if (result == 3) {
				System.out.println("5등 당첨을 축하합니다.");
				System.out.println("당첨금은 5천원입니다.");
				
				Map<String, Object> userObj = new HashMap<>();
				userObj.put("user_id", user_id);
				userObj.put("user_point", 5000);
				iUserService.addPoint(userObj);
			} else {
				System.out.println("아쉽지만 꽝입니다.");
			}
		}
	}

	public List<Set<Integer>> selectLotto(int input) {
		List<Set<Integer>> lottoList = new ArrayList<>();
		while (lottoList.size() < input) {
			System.out.println(lottoList.size() + 1 + "번째 Lotto 구매를 시작합니다.");
			Set<Integer> lottoSet = new HashSet<>();
			while (lottoSet.size() < 6) {
				System.out.println(lottoSet.size() + 1 + "번째 숫자를 입력해주세요. ( 1 ~ 45 사이의 숫자를 입력해주세요. )");
				int num = iInput();
				if (num < 1 || num > 45) {
					System.out.println("1 ~ 45 사이의 값만 입력 가능합니다.");
					continue;
				}
				if (lottoSet.add(num)) {
					System.out.println(lottoSet.size() + "번째 숫자가 입력되었습니다.");
				} else {
					System.out.println("이미 입력된 숫자입니다.");
				}
			}
			lottoList.add(lottoSet);
			System.out.println(lottoList.size() + "번째 Lotto 구매가 완료되었습니다.");
		}
		return lottoList;
	}

	public List<Set<Integer>> autoSelectLotto(int input) {
		List<Set<Integer>> lottoList = new ArrayList<>();
		while (lottoList.size() < input) {
			Set<Integer> lottoSet = new HashSet<>();
			while (lottoSet.size() < 6) {
				lottoSet.add((int) (Math.random() * 45 + 1));
			}
			lottoList.add(lottoSet);
			System.out.println(lottoList.size() + "번째 자동 선택 : " + lottoSet);
		}
		return lottoList;
	}

	public static List<Integer> parseLotto(int num) throws Exception {
		List<Integer> parseLotto = new ArrayList<>();
		URL url = new URL("https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=" + (num + 1));
		InputStreamReader isr = new InputStreamReader(url.openConnection().getInputStream(), "UTF-8");
		JSONObject object = (JSONObject) JSONValue.parse(isr);
		for (int i = 0; i < 6; i++) {
			parseLotto.add(Integer.valueOf(String.valueOf(object.get("drwtNo" + (i + 1)))));
		}
		parseLotto.add(Integer.valueOf(String.valueOf(object.get("bnusNo"))));
		return parseLotto;
	}
}
