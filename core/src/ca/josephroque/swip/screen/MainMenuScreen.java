package ca.josephroque.swip.screen;

import ca.josephroque.swip.SwipGame;
import com.badlogic.gdx.Gdx;

/**
 * Displays a main menu when the user begins the app. Provides options such as starting a new game, viewing high
 * scores...
 */
public final class MainMenuScreen
        extends SwipScreen {

    /** Width of the screen. */
    private int mScreenWidth;
    /** Height of the screen. */
    private int mScreenHeight;

    @Override
    public void tick() {
        if (Gdx.input.justTouched()) {
            getSwipGame().setState(SwipGame.SwipState.Game);
            dispose();
        }
    }

    @Override
    public void draw(float delta) {
    }

    @Override
    public void show() {
        mScreenWidth = Gdx.graphics.getWidth();
        mScreenHeight = Gdx.graphics.getHeight();
    }

    @Override
    public void render(float delta) {
        tick();

        if (!wasDisposed())
            draw(delta);
    }

    @Override
    public void dispose() {
        disposeEventually();
    }

    @Override
    public void resize(int width, int height) {
        mScreenWidth = width;
        mScreenHeight = height;
    }

    /**
     * Passes parameters to super constructor.
     *
     * @param game instance of game
     */
    public MainMenuScreen(SwipGame game) {
        super(game);
    }
}
