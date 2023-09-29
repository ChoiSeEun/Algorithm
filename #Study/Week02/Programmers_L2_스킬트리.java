package ssafy.study.Week02;

import java.util.*;
import java.io.*;

public class Programmers_L2_스킬트리 {
	
	public static int solution(String skill, String[] skill_trees) {
		int cnt = skill_trees.length;
		// 스킬트리 배열 하나씩 확인 
		for(int i=0;i<skill_trees.length;i++) {
			next:for(int j=0;j<skill.length();j++) {
				// 해당 스킬의 인덱스 찾기 
				int nowSkillIdx = skill_trees[i].indexOf(skill.charAt(j));
				// 나머지 스킬 
				String nextSkill = skill.substring(j+1);
				// 해당 스킬이 없는 경우 
				if(nowSkillIdx==-1) {
					for(int k=0;k<skill_trees[i].length();k++) {
						if(nextSkill.contains(Character.toString(skill_trees[i].charAt(k)))) {
							cnt--;
							break next;
						}
					}
				}
				// 해당 스킬이 있는 경우 
				else {
					// 해당 스킬 위치 전까지 확인 
					for(int k=0;k<nowSkillIdx;k++) {
						if(nextSkill.contains(Character.toString(skill_trees[i].charAt(k)))) {
							cnt--;
							break next;
						}
					}
				}
			}
		}
		return cnt;
	}
	public static void main(String args[]) throws Exception
	{
		String skill  ="CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		System.out.println(solution(skill,skill_trees));
	}
}