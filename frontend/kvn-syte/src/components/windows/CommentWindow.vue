<template>
    <div class="back">
        <div class="window">
            <div class="ui buttons" style="position: absolute; top: 5px; right: 5px; z-index: 997;">
                <div class="ui icon button" @click="$emit('quit')">
                    <i class="x icon"></i>
                </div>
            </div>
            <div class="ui text container segment" style="width: 100%;">
                <h2 class="ui header">
                    Комментарий #{{ props.commentId }}
                </h2>
                <div class="ui segment" align="left">
                    <p><b> {{ comment.user }} </b></p>
                    <p> {{ comment.text }} </p>
                    <p align="right"> {{ comment.time }}</p>
                </div>
                <div class="ui clearing divider"></div>
                <button class = "ui primary button" @click="$emit('show')">Открыть пост</button>
                <button class = "ui negative button" @click="$emit('delete')">Удалить комментарий</button>
                <button class = "ui button" @click="$emit('quit')">Выйти</button>
            </div>
        </div>
    </div>
</template>

<script setup>
import { ref } from 'vue';


const props = defineProps({
    commentId: {
        required: true
    }
})

//const emit = defineEmits(['quit', 'edit', 'block', 'delete'])

// Заглушка-комментарий
const comment = ref({
    user: "Аноним",
    text: "Abacaba",
    time: "26.02.19T19:00"
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