package Educative.Facebook.features;

import Educative.Facebook.enums.FriendsListVisibility;
import Educative.Facebook.profilesdetails.Profile;

public class ProfilePrivacy {
        /**
         * Change who can see the user's friends list.
         * @param profile The user's profile.
         * @param visibility The desired visibility (PUBLIC, FRIENDS_ONLY, ONLY_ME).
         */
        public void changeFriendsListVisibility(Profile profile, FriendsListVisibility visibility) {
                if (profile != null) {
                        profile.setFriendsListVisibility(visibility);
                        // Optionally: Log action, notify user, etc.
                }
        }
        /**
         * Lock the user's profile (prevents strangers from seeing most details).
         * @param profile The user's profile.
         */
        public void lockProfile(Profile profile) {
                if (profile != null) {
                        profile.setProfileLocked(true);
                        // Optionally: Hide timeline, restrict posts, etc.
                }
        }

        /**
         * Lock the user's profile picture (only friends can see it, or hides it from everyone).
         * @param profile The user's profile.
         */
        public void lockProfilePicture(Profile profile) {
                if (profile != null) {
                        profile.setProfilePictureLocked(true);
                        // Optionally: Replace with a default image for non-friends.
                }
        }

        /**
         * Unlock the user's profile (if you want to provide this option).
         */
        public void unlockProfile(Profile profile) {
                if (profile != null) {
                        profile.setProfileLocked(false);
                }
        }

        /**
         * Unlock the user's profile picture (if you want to provide this option).
         */
        public void unlockProfilePicture(Profile profile) {
                if (profile != null) {
                        profile.setProfilePictureLocked(false);
                }
        }
}
