<template>
    <div class="back">
        <div class="window">
            <div class="ui buttons" style="position: absolute; top: 5px; right: 5px; z-index: 997;">
                <div class="ui icon button" @click="$emit('quit')">
                    <i class="x icon"/>
                </div>
            </div>
            <div class="ui text container segment">
                <h2 class="ui header">
                    Настройки публикации для {{props.title}}
                </h2>
                <div class="ui form">
                    <div class="grouped fields">
                        <label for="role">Тип использования стиля:</label>
                        <div class="field">
                            <div class="ui radio checkbox">
                                <input type="radio" name="role" value="none" v-model="settings.role">
                                <label>Нет</label>
                            </div>
                        </div>
                        <div class="field">
                            <div class="ui radio checkbox">
                                <input type="radio" name="role" value="dark-theme" v-model="settings.role">
                                <label>Тёмная тема</label>
                            </div>
                        </div>
                        <div class="field">
                            <div class="ui radio checkbox">
                                <input type="radio" name="role" value="blind" v-model="settings.role">
                                <label>Версия для слабовидящих</label>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="ui divider" />
                <button class = "ui button primary" @click="$emit('publish')">Опубликовать стиль</button>
                <button class = "ui button" @click="$emit('quit')">Отмена</button>
            </div>
        </div>
    </div>
</template>

<script setup>
import { ref } from 'vue';

const props = defineProps({
    title: {
        type: String,
        required: true
    }
})

const settings = ref({
    role: 'none'
})

</script>

<style scoped>
.window {
  position: fixed;
  z-index: 999;
  top: 15%;
  left: 30%;
  width: 40%;
  background-color: #ffffff;
  border: 3px solid #000000;
  padding: 15px 15px;
}

.back {
    position: fixed;
    z-index: 998;
    top: 0%;
    left: 0%;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
}
</style>