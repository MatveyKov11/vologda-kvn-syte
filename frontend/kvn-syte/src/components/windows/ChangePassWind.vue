<template>
    <div class="back">
        <div class="window">
            <div class="ui text container segment">
                <h2 class="ui header">
                    Изменение пароля для {{props.profile.login}}
                </h2>
                <div class="field">
                    <div class="ui left icon fluid input">
                        <i class="lock icon"></i>
                        <input type="password" name="password" v-model="pass" placeholder="Пароль">
                    </div>
                </div>
                <div class="field">
                    <div class="ui left icon fluid input">
                        <i class="lock icon"></i>
                        <input type="password" name="password" v-model="passCopy" placeholder="Подтвердите пароль">
                    </div>
                </div>
                <div class="ui left red message" v-if="!isCorrectPass">
                    <i class="times icon"></i>
                    Пароли не совпадают
                </div>
                <div class="ui left green message" v-else>
                    <i class="check icon"></i>
                    Пароли совпадают
                </div>
                <button class = "ui button primary" @click="changePass" :disabled="!isCorrectPass || !pass">Поменять пароль</button>
                <button class = "ui button" @click="$emit('quit')">Отмена</button>
            </div>
        </div>
    </div>
</template>

<script setup>
import { ref, computed } from 'vue';

const props = defineProps({
    profile: {
        required: true
    }
})

const emit = defineEmits(['quit'])

const pass = ref("")
const passCopy = ref("")

const isCorrectPass = computed(() => {
    return pass.value == passCopy.value
})

function changePass(){
    alert('Заглушка: пароль поменялся!')
    emit('quit')
}
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