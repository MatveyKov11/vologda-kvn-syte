<template>
    <div class="ui text container">
        <h2 class="ui header">
            <div class="content">
                Награды
            </div>
        </h2>
    </div>
    <div class="ui hidden divider"></div>
    <div class="ui input">
        <input type="text" name="name" v-model="tableTitle" placeholder="Название таблицы">
    </div>
    <table class="ui table">
        <thead>
            <tr>
                <th class="center aligned">Описание награды</th>
                <th class="center aligned">Кого наградили</th>
                <th class="one wide"></th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="(reward, i) in rewards" :key="i" @mouseover="reward.isVisible = true" @mouseleave="reward.isVisible = false">
                <td>
                    <div class="ui fluid input">
                        <input type="text" name="description" v-model="reward.description">
                    </div>
                </td>
                <td>
                    <div class="ui fluid input">
                        <input type="text" name="to" v-model="reward.to">
                    </div>
                </td>
                <td>
                    <div class="ui icon red button" @click="deleteRow(i)" v-if="reward.isVisible">
                        <i class="x icon"/>
                    </div>
                </td>
            </tr>
        </tbody>
    </table>
    <button class="ui primary button" @click="addRow">
        <i class="plus icon"/> Добавить награду
    </button>
    <button class="ui green button" @click="saveChanges">
        <i class="check icon"/> Сохранить изменения
    </button>
    <button class="ui button" @click="lookTable">
        <i class="eye icon"/> Предпросмотр таблицы
    </button>
    <TableWindow :tableId="-1" :table="table" v-if="isLook" @quit="isLook = false; table = {columns: [], rows: []}"/>
</template>

<script setup>
import router from '@/router';
import { ref } from 'vue';
import TableWindow from '../windows/TableWindow.vue';

const props = defineProps({
    table: {
        type: Object,
        required: true
    }
})

const rewards = ref([
    {
        description: "Лучшая мужская роль",
        to: "Денис Давыдов из '99 стайл'",
        isVisible: false  // !!!
    },
    {
        description: "Лучшая женская роль",
        to: "Саша Нивина из '35 элемент'",
        isVisible: false  // !!!
    }
])
const tableTitle = ref("")
const table = ref({
    title: "",
    columns: [],
    rows: []
})
const isLook = ref(false)

if (props.table.rewards){
    rewards.value = JSON.parse(JSON.stringify(props.table.rewards))
    tableTitle.value = ''+props.table.title
}

function deleteRow(r){
    let rewardsCopy = []
    for(let i = 0; i < rewards.value.length; i++){
        if(i != r){
            rewardsCopy.push(rewards.value[i])
        }
    }
    rewards.value = rewardsCopy
}

function addRow(){
    rewards.value.push({})
}

function saveChanges(){
    alert('Заглушка! Изменения сохранены!')
    router.push({name: 'Admin Home'})
}

function lookTable(){
    table.value.title = tableTitle.value
    table.value.columns = ["Описание награды", "Кого наградили"]

    rewards.value.forEach(reward => {
        table.value.rows.push([
            reward.description, reward.to
        ])
    })

    isLook.value = true
}
</script>