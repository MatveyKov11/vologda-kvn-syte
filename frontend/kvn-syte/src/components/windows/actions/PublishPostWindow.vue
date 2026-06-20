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
                <div class="ui input">
                    <p>Отключить комментарии под постом: {{ settings.lockComments ? 'Да' : 'Нет' }}</p>
                    <input type="checkbox" v-model="settings.lockComments">
                </div>
                <div class="ui divider" />
                <button class = "ui button primary" @click="$emit('publish')">Опубликовать пост</button>
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
    lockComments: false
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