class Solution {
    static class Robot {
        int position;
        int health;
        char direction;
        int index;

        Robot(int position, int health, char direction, int index) {
            this.position = position;
            this.health = health;
            this.direction = direction;
            this.index = index;
        }
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Robot[] robots = new Robot[n];
        
        // Create Robot objects and store them in an array
        for (int i = 0; i < n; i++) {
            robots[i] = new Robot(positions[i], healths[i], directions.charAt(i), i);
        }

        // Sort robots based on positions
        Arrays.sort(robots, Comparator.comparingInt(r -> r.position));

        Deque<Robot> stack = new ArrayDeque<>();
        
        for (Robot robot : robots) {
            if (robot.direction == 'R') {
                stack.push(robot);
            } else {
                while (!stack.isEmpty() && stack.peek().direction == 'R') {
                    Robot rightRobot = stack.peek();
                    if (rightRobot.health < robot.health) {
                        robot.health -= 1;
                        stack.pop();
                    } else if (rightRobot.health == robot.health) {
                        stack.pop();
                        robot = null;
                        break;
                    } else {
                        rightRobot.health -= 1;
                        robot = null;
                        break;
                    }
                }
                if (robot != null) {
                    stack.push(robot);
                }
            }
        }

        // Create a map to collect final healths in original order
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (Robot robot : stack) {
            resultMap.put(robot.index, robot.health);
        }

        // Create a list to return the final healths
        List<Integer> finalHealthList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (resultMap.containsKey(i)) {
                finalHealthList.add(resultMap.get(i));
            }
        }

        return finalHealthList;
    }
}