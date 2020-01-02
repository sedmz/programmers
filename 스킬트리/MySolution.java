class MySolution {
	public boolean isRightSkillTree(String skill, String skill_tree) {
		int beforeCharIndex, charIndex = -1;
		for (int i = 0; i < skill.length(); i++) {
			char ch = skill.charAt(i);

			beforeCharIndex = charIndex;
			charIndex = skill_tree.indexOf(ch);
			if (charIndex == -1)
				charIndex = skill_tree.length();

			if (beforeCharIndex > charIndex)
				return false;
		}
		return true;
	}

	public int solution(String skill, String[] skill_trees) {
		int cnt = 0;
		for (String skill_tree : skill_trees) {
			if (isRightSkillTree(skill, skill_tree))
				cnt++;
		}
		return cnt;
	}

	public static void main(String[] args) {
		MySolution sol = new MySolution();
		String skill = "CBD";
		String[] skill_trees = { "cAEBC", "CBADF", "AECB", "BDA" };
		sol.solution(skill, skill_trees);
	}
}
