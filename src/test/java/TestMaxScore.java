import org.example.Solution;
import org.junit.Assert;
import org.junit.Test;

public class TestMaxScore {
    @Test
    public void maxScoreTest1() {
        int[] nums1 = {1, 3, 3, 2};
        int[] nums2 = {2, 1, 3, 4};
        Assert.assertEquals(12, new Solution().maxScore(nums1, nums2, 3));
    }

    @Test
    public void maxScoreTest2() {
        int[] nums1 = {4, 2, 3, 1, 1};
        int[] nums2 = {7, 5, 10, 9, 6};
        Assert.assertEquals(30, new Solution().maxScore(nums1, nums2, 1));
    }
}
