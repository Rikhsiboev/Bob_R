package PrepInterview;

public class LineJumps {
    public static void main(String[] args) {
        int kangarooX1 = 0;
        int kangarooX2 = 4;
        int meterPerJumpV1 = 3;
        int meterPerJumpV2 = 2;
        System.out.println(isItMeetAtSameLocation(kangarooX1, kangarooX2, meterPerJumpV1, meterPerJumpV2));
    }

    public static String isItMeetAtSameLocation(int kangarooX1, int kangarooX2, int meterPerJumpV1, int meterPerJumpV2) {
        if (meterPerJumpV1 == meterPerJumpV2) {
            if (kangarooX1 == kangarooX2) {
                return "YES"; // They start at the same position and have the same jump distance, so they meet.
            } else {
                return "NO"; // They have the same jump distance but start at different positions, so they'll never meet.
            }
        } else {
            int relativeStartPosition = kangarooX2 - kangarooX1;
            int relativeJumpDistance = meterPerJumpV1 - meterPerJumpV2;

            if (relativeStartPosition % relativeJumpDistance == 0 && relativeStartPosition / relativeJumpDistance >= 0) {
                return "YES"; // They will meet at the same position.
            } else {
                return "NO"; // They will not meet at the same position.
            }
        }
    }
}
