package com.github.warrentode.turtleblockacademy.blocks.entity.gui;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.BookViewScreen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerListener;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class SchoolDeskScreen extends BookViewScreen implements MenuAccess<SchoolDeskMenu> {
    private final SchoolDeskMenu menu;

    private final ContainerListener listener = new ContainerListener() {
        /** Sends the contents of an inventory slot to the client-side Container. 
         This doesn't have to match the actual contents of that slot. */
        public void slotChanged(@NotNull AbstractContainerMenu abstractContainerMenu, int slotIndex, @NotNull ItemStack stack) {
            SchoolDeskScreen.this.bookChanged();
        }

        public void dataChanged(@NotNull AbstractContainerMenu abstractContainerMenu, int slotIndex, int value) {
            if (slotIndex == 0) {
                SchoolDeskScreen.this.pageChanged();
            }
        }
    };

    public SchoolDeskScreen(SchoolDeskMenu menu, Inventory ignoredPlayerInventory, Component ignoredComponent) {
        this.menu = menu;
    }

    @Override
    public @NotNull SchoolDeskMenu getMenu() {
        return this.menu;
    }

    protected void init() {
        super.init();
        this.menu.addSlotListener(this.listener);
    }

    public void onClose() {
        assert this.minecraft != null;
        assert this.minecraft.player != null;

        this.minecraft.player.closeContainer();
        super.onClose();
    }

    public void removed() {
        super.removed();
        this.menu.removeSlotListener(this.listener);
    }

    protected void createMenuControls() {
        assert this.minecraft != null;
        assert this.minecraft.player != null;

        if (this.minecraft.player.mayBuild()) {
            this.addRenderableWidget(new Button(this.width / 2 - 100, 196, 98, 20, CommonComponents.GUI_DONE, (button) -> this.onClose()));
            this.addRenderableWidget(new Button(this.width / 2 + 2, 196, 98, 20, Component.translatable("lectern.take_book"), (button) -> this.sendButtonClick(3)));
        }
        else {
            super.createMenuControls();
        }
    }

    protected void pageBack() {
        this.sendButtonClick(1);
    }

    protected void pageForward() {
        this.sendButtonClick(2);
    }

    protected boolean forcePage(int pageNum) {
        if (pageNum != this.menu.getPage()) {
            this.sendButtonClick(100 + pageNum);
            return true;
        }
        else {
            return false;
        }
    }

    private void sendButtonClick(int pageData) {
        assert this.minecraft != null;
        assert this.minecraft.gameMode != null;

        this.minecraft.gameMode.handleInventoryButtonClick(this.menu.containerId, pageData);
    }

    public boolean isPauseScreen() {
        return false;
    }

    void bookChanged() {
        ItemStack book = this.menu.getBook();
        this.setBookAccess(BookAccess.fromItem(book));
    }

    void pageChanged() {
        this.setPage(this.menu.getPage());
    }

    protected void closeScreen() {
        assert this.minecraft != null;
        assert this.minecraft.player != null;

        this.minecraft.player.closeContainer();
    }
}
