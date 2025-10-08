package Educative.Facebook.accounts;

import Educative.Facebook.enums.AccountStatus;
import Educative.Facebook.features.Group;
import Educative.Facebook.features.Page;
import Educative.Facebook.services.SystemWideBlockList;
import Educative.Facebook.notications.Notification;
import Educative.Facebook.search.SearchCatalog;
import Educative.Facebook.services.NotificationService;

import java.time.LocalDate;
import java.util.List;

public class Admin {

    // Blocks a user by setting their account status to BLOCKED
    public void blockUser(User user) {
        if (user != null && user.getAccount() != null) {
            user.getAccount().setStatus(AccountStatus.BLOCKED);
            // Optionally: Add to a system-wide block list, log action, send notification, etc.

            SystemWideBlockList.getInstance().addBlockedUser(user);

            System.out.println("Admin blocked user: " + user.getName());

            // Send notification
            NotificationService.getInstance().send(
                    new Notification(0, LocalDate.now(), "Your account has been blocked by an admin."), user
            );
        }
    }

    // Unblocks a user by setting their account status to ACTIVE
    public void unblockUser(User user) {
        if (user != null && user.getAccount() != null) {
            user.getAccount().setStatus(AccountStatus.ACTIVE);
            // Optionally: Remove from block list, log action, send notification, etc.
            SystemWideBlockList.getInstance().removeBlockedUser(user);

            System.out.println("Admin unblocked user: " + user.getName());

            NotificationService.getInstance().send(
                    new Notification(0, LocalDate.now(), "Your account has been unblocked by an admin."), user
            );
        }
    }

    // Enables a page by setting its like count to 0 if negative (or another enabled flag)
    public void enablePage(Page page) {
        if (page != null) {
            // Suppose you have a boolean flag for enabled; if not, you could use likeCount or other logic
            // page.setEnabled(true);
            if (page.getLikeCount() < 0) {
                page.setLikeCount(0);
            }
            // Optionally: Send notification to page admins, log action, etc.
            page.setLikeCount(-1);

            List<User> admins = page.getAdmins();
            if (admins != null) {
                for (User admin : admins) {
                    NotificationService.getInstance().send(
                            new Notification(0, LocalDate.now(),  "Your page \"" + page.getName() + "\" has been enabled by admin."), admin
                    );
                }
            }
            System.out.println("Admin enabled page: " + page.getName());
        }
    }

    // Disables a page by setting its like count to -1 (or another disabled flag)
    public void disablePage(Page page) {
        if (page != null) {
            // Suppose you have a boolean flag for enabled; if not, you could use likeCount or other logic
            // page.setEnabled(false);
            if (page.getLikeCount() < 0) {
                page.setLikeCount(0);
            }

            // Optionally: Send notification to page admins, log action, etc.
            List<User> admins = page.getAdmins();
            if (admins != null) {
                for (User admin : admins) {
                    NotificationService.getInstance().send(
                            new Notification(0,LocalDate.now(), "Your page \"" + page.getName() + "\" has been disabled by admin."), admin
                    );
                }
            }

            // Log action
            System.out.println("Admin disabled page: " + page.getName());
        }
    }

    // Deletes a group by clearing its user list and marking as deleted (could also remove from system-wide group list)
    public void deleteGroup(Group group) {
        if (group != null) {

            // Optionally: Mark as deleted
            for (User user : group.getUsers()) {
                NotificationService.getInstance().send(
                        new Notification(0, LocalDate.now(), "The group \"" + group.getName() + "\" has been deleted by admin."), user
                );
            }

            // Optionally: Mark as deleted
            group.setDeleted(true);

            SearchCatalog.getInstance().removeGroup(group);

            System.out.println("Admin deleted group: " + group.getName());

            // Clear group members and reset count
            group.getUsers().clear();
            group.setTotalUsers(0);
        }
    }

    // Changes group privacy (toggles isPrivate flag)
    public void changeGroupPrivacy(Group group) {
        if (group != null) {
            group.setPrivate(!group.isPrivate());
            // Optionally: Notify group members, log action, etc.
            for (User user : group.getUsers()) {
                NotificationService.getInstance().send(
                        new Notification(0, LocalDate.now(), "The privacy setting of group \"" + group.getName() + "\" has been changed by admin."), user
                );
            }

            // Log action
            System.out.println("Admin changed privacy for group: " + group.getName());
        }
    }
}
