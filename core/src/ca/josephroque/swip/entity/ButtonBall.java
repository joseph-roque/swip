package ca.josephroque.swip.entity;

import ca.josephroque.swip.manager.TextureManager;
import ca.josephroque.swip.input.GameInputProcessor;
import ca.josephroque.swip.manager.MenuManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Balls for offering button interactions.
 */
public class ButtonBall
        extends BasicBall {

    /** Identifies output from this class in the logcat. */
    @SuppressWarnings("unused")
    private static final String TAG = "ButtonBall";

    /** Menu action which clicking this ball invokes. */
    private MenuManager.MenuBallOption mMenuOption;
    /** Icon of the button. */
    private TextureRegion mButtonIcon;

    /**
     * Prepares a new ball object.
     *
     * @param option menu item the ball represents
     * @param ballColor color of the ball
     * @param buttonIcon icon for the button
     * @param x starting horizontal position of the ball
     * @param y starting vertical position of the ball
     */
    public ButtonBall(MenuManager.MenuBallOption option,
                      TextureManager.GameColor ballColor,
                      TextureRegion buttonIcon,
                      float x,
                      float y) {
        super(ballColor, x, y);
        mMenuOption = option;
        mButtonIcon = buttonIcon;
    }

    /**
     * Checks to see if the user clicked the ball.
     *
     * @param gameInput player's input events
     * @return {@code true} if the user clicked within the bounds of the button.
     */
    public boolean wasClicked(GameInputProcessor gameInput) {
        return gameInput.clickOccurred() && getBounds().contains(gameInput.getLastFingerX(),
                gameInput.getLastFingerY());
    }

    /**
     * Draws the ball and its icon to the screen.
     *
     * @param spriteBatch graphics context to draw to
     * @param textureManager to get texture to draw
     */
    public void draw(SpriteBatch spriteBatch, TextureManager textureManager) {
        super.draw(spriteBatch, textureManager);

        if (mButtonIcon != null)
            drawIcon(spriteBatch);
    }

    /**
     * Draws the button's icon over top of the ball.
     *
     * @param spriteBatch graphics context to draw to
     */
    private void drawIcon(SpriteBatch spriteBatch) {
        spriteBatch.draw(mButtonIcon, getX() - getRadius(), getY() - getRadius(), getWidth(), getHeight());
    }

    /**
     * Gets the option that clicking this ball invokes.
     *
     * @return menu option
     */
    public MenuManager.MenuBallOption getMenuOption() {
        return mMenuOption;
    }
}
